package designpattern.u25;

import Ch_1_4._Stopwatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by HuGuodong on 12/30/19.
 */
public class UserController {

  private MonitorStats stats = new MonitorStats();

  public UserController() {
    stats.startRepeatedReport(60, TimeUnit.SECONDS);
  }

  public void register() {
    _Stopwatch stopwatch = new _Stopwatch();
    stats.recordResponseTimeStamp("register", stopwatch.start());
    // logic

    stats.recordResponseTime("register", stopwatch.elapsedTimeLong());
  }

  public void login() {
    _Stopwatch stopwatch = new _Stopwatch();
    stats.recordResponseTimeStamp("login", stopwatch.start());
    // logic
    stats.recordResponseTime("login", stopwatch.elapsedTimeLong());
  }
}
