package designpattern.u29;

/**
 * Created by HuGuodong on 1/8/20.
 */
public class TransactionLock {

  public boolean lock(String id) {
    return RedisDistributedLock.getSingletonInstance().lockTransaction(id);
  }

  public void unlock(String id) {
    RedisDistributedLock.getSingletonInstance().unlockTransaction(id);
  }
}

