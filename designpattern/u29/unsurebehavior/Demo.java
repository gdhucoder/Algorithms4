package designpattern.u29.unsurebehavior;

import java.util.Date;

/**
 * Created by HuGuodong on 1/8/20.
 */

public class Demo {

  public long calculateDelayDays(Date dueTime) {
    long currentTimestamp = getCurrentTimestamp();
    if (dueTime.getTime() >= currentTimestamp) {
      return 0;
    }
    long delayTime = currentTimestamp - dueTime.getTime();
    long delayDays = delayTime / (24 * 3600 * 1000L);
    return delayDays;
  }

  public long getCurrentTimestamp() {
    return System.currentTimeMillis();
  }
}