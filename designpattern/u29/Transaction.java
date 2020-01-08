package designpattern.u29;

/**
 * Created by HuGuodong on 1/8/20.
 */

public class Transaction {

  private String id;
  private Long buyerId;
  private Long sellerId;
  private Long productId;
  private String orderId;
  private Long createTimestamp;
  private Double amount;
  private STATUS status;
  private String walletTransactionId;
  private WalletRpcService walletRpcService;
  private TransactionLock lock;

  public void setWalletRpcService(WalletRpcService rpcService) {
    this.walletRpcService = rpcService;
  }

  public void setLock(TransactionLock lock) {
    this.lock = lock;
  }

  public boolean isExpired() {
    long executionInvokedTimestamp = System.currentTimeMillis();
    if (executionInvokedTimestamp - createTimestamp > 14L * 24 * 3600 * 1000) {
      return true;
    }
    return false;
  }

  // ...get() methods...

  public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId,
      String orderId, Double amount) {
    if (preAssignedId != null && !preAssignedId.isEmpty()) {
      this.id = preAssignedId;
    } else {
      this.id = IdGenerator.generateTransactionId();
    }
    if (!this.id.startsWith("t_")) {
      this.id = "t_" + preAssignedId;
    }
    this.buyerId = buyerId;
    this.sellerId = sellerId;
    this.productId = productId;
    this.orderId = orderId;
    this.status = STATUS.TO_BE_EXECUTD;
    this.createTimestamp = System.currentTimeMillis(); // ?
    this.amount = amount;
  }

  public boolean execute() throws InvalidTransactionException {
    if ((buyerId == null || sellerId == null || amount < 0.0)) {
      throw new InvalidTransactionException("InvalidTrans");
    }
    if (status == STATUS.EXECUTED)
      return true;
    boolean isLocked = false;
    try {
//      isLocked = RedisDistributedLock.getSingletonInstance().lockTransaction(id);
      isLocked = lock.lock(id);
      if (!isLocked) {
        return false; // 锁定未成功，返回false，job兜底执行
      }
      if (status == STATUS.EXECUTED)
        return true; // double check
      long executionInvokedTimestamp = System.currentTimeMillis();
//      if (executionInvokedTimestamp - createTimestamp > 14L*24*3600*1000){
//        this.status = STATUS.EXPIRED;
//        return false;
//      }

      if (isExpired()) {
        this.status = STATUS.EXPIRED;
        return false;
      }

      String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
      if (walletTransactionId != null) {
        this.walletTransactionId = walletTransactionId;
        this.status = STATUS.EXECUTED;
        return true;
      } else {
        this.status = STATUS.FAILED;
        return false;
      }
    } finally {
      if (isLocked) {
//        RedisDistributedLock.getSingletonInstance().unlockTransaction(id);
        lock.unlock(id);
      }
    }
  }

  public String getId() {
    return id;
  }

  public Long getBuyerId() {
    return buyerId;
  }

  public Long getSellerId() {
    return sellerId;
  }

  public Long getProductId() {
    return productId;
  }

  public String getOrderId() {
    return orderId;
  }

  public Long getCreateTimestamp() {
    return createTimestamp;
  }

  public Double getAmount() {
    return amount;
  }

  public STATUS getStatus() {
    return status;
  }

  public String getWalletTransactionId() {
    return walletTransactionId;
  }

  public WalletRpcService getWalletRpcService() {
    return walletRpcService;
  }
}
