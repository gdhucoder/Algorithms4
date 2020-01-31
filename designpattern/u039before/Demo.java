package designpattern.u039before;

import designpattern.u039before.reporter.ConsoleReporter;
import designpattern.u039before.storage.MetricsStorage;
import designpattern.u039before.storage.MockRedisMetricsStorage;

/**
 * Created by HuGuodong on 1/31/20.
 */

public class Demo {

  public static void main(String[] args) {
    MetricsStorage storage = new MockRedisMetricsStorage();
    ConsoleReporter consoleReporter = new ConsoleReporter(storage);
    consoleReporter.startRepeatedReport(2, 2);

//    EmailReporter emailReporter = new EmailReporter(storage);
//    emailReporter.addToAddress("wangzheng@xzg.com");
//    emailReporter.startDailyReport();

    MetricsCollector collector = new MetricsCollector(storage);
    collector.recordRequest(new RequestInfo("register", 123, 10234));
    collector.recordRequest(new RequestInfo("register", 223, 11234));
    collector.recordRequest(new RequestInfo("register", 323, 12334));
    collector.recordRequest(new RequestInfo("login", 23, 12434));
    collector.recordRequest(new RequestInfo("login", 1223, 14234));

//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
  }
}