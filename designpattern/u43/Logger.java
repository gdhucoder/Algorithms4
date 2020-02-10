package designpattern.u43;

import java.util.concurrent.ConcurrentHashMap;
import org.junit.Assert;

/**
 * Created by HuGuodong on 2/10/20.
 */

public class Logger {

  private static final ConcurrentHashMap<String, Logger> instances
      = new ConcurrentHashMap<>();

  private Logger() {}

  public static Logger getInstance(String loggerName) {
    instances.putIfAbsent(loggerName, new Logger());
    return instances.get(loggerName);
  }

  public void log() {
    //...
  }

  public static void main(String[] args) {
    //l1==l2, l1!=l3
    Logger l1 = Logger.getInstance("User.class");
    Logger l2 = Logger.getInstance("User.class");
    Logger l3 = Logger.getInstance("Order.class");
    Assert.assertEquals(l1, l2);
    Assert.assertFalse(l2 == l3);
  }
}

