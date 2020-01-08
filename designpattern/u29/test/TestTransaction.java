package designpattern.u29.test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import designpattern.u29.STATUS;
import designpattern.u29.Transaction;
import designpattern.u29.TransactionLock;
import org.junit.Test;

/**
 * Created by HuGuodong on 1/8/20.
 */
public class TestTransaction {

  /**
   * Test 1 正常情况下，交易执行成功，回填用于对账（交易与钱包的交易流水） 用的 walletTransactionId，交易状态设置为 EXECUTED，函数返回 true。
   */
  @Test
  public void testExecute() {
    Long buyerId = 123L;
    Long sellerId = 234L;
    Long productId = 345L;
    String orderId = "456L";
    Transaction transaction = new Transaction(null, buyerId,
        sellerId, productId, orderId, 100D);
    // 使用mock对象来替代真正的RPC服务
    transaction.setWalletRpcService(new MockWalletRpcServiceOne());
    TransactionLock mockLock = new TransactionLock() {
      @Override
      public boolean lock(String id) {
        return true;
      }

      @Override
      public void unlock(String id) {

      }
    };
    transaction.setLock(mockLock);
    boolean executedResult = false;
    try {
      executedResult = transaction.execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
    assertTrue(executedResult);
    assertEquals(STATUS.EXECUTED, transaction.getStatus());
  }
//  buyerId、sellerId 为 null、amount 小于 0，返回 InvalidTransactionException。

//  交易已过期（createTimestamp 超过 14 天），交易状态设置为 EXPIRED，返回 false。

  @Test
  public void testExecute_with_TransactionIsExpired() {
    Long buyerId = 123L;
    Long sellerId = 234L;
    Long productId = 345L;
    String orderId = "456L";
    Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId, 10D) {
      @Override
      public boolean isExpired() {
        return true;
      }
    };
    TransactionLock mockLock = new TransactionLock() {
      @Override
      public boolean lock(String id) {
        return true;
      }

      @Override
      public void unlock(String id) {

      }
    };
    transaction.setLock(mockLock);
//    transaction.setCreatedTimestamp(System.currentTimestamp() - 14days);
    boolean actualResult = false;
    try {
      actualResult = transaction.execute();
    } catch (Exception e) {
      e.printStackTrace();
    }

    assertFalse(actualResult);
    assertEquals(STATUS.EXPIRED, transaction.getStatus());
  }
//  交易已经执行了（status==EXECUTED），不再重复执行转钱逻辑，返回 true。
//  钱包（WalletRpcService）转钱失败，交易状态设置为 FAILED，函数返回 false。
//  交易正在执行着，不会被重复执行，函数直接返回 false。

}
