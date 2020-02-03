package designpattern.u40;

import designpattern.u40.factory.ReporterFactory;
import designpattern.u40.reporter.ConsoleReporter;
import designpattern.u40.storage.MetricsStorage;
import designpattern.u40.storage.MockRedisMetricsStorage;
import designpattern.u40.viewer.ConsoleViewer;
import org.junit.Test;

/**
 * Created by HuGuodong on 1/31/20.
 */

public class Demo {

  public static void main(String[] args) {
//    output
//    Time Span: [1580732440785, 1580732442785]
//    {"login":{"maxResponseTime":1223.0,"minResponseTime":23.0,"avgResponseTime":623.0,"p999ResponseTime":1223.0,"p99ResponseTime":1223.0,"count":2,"tps":0},"register":{"maxResponseTime":323.0,"minResponseTime":123.0,"avgResponseTime":223.0,"p999ResponseTime":323.0,"p99ResponseTime":323.0,"count":3,"tps":0}}

    MetricsStorage storage = new MockRedisMetricsStorage();
    ConsoleReporter consoleReporter = ReporterFactory.createConsoleReporter(storage);
    consoleReporter.startRepeatedReport(2, 2);
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

    try {
      Thread.sleep(4000);
      consoleReporter.startRepeatedReport(2, 2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testConsoleReporter() {
    MetricsStorage storage = new MockRedisMetricsStorage();
    ConsoleReporter consoleReporter = ReporterFactory.createConsoleReporter(storage);
    consoleReporter.startRepeatedReport(2, 2);
    MetricsCollector collector = new MetricsCollector(storage);
    collector.recordRequest(new RequestInfo("register", 123, 10234));
    collector.recordRequest(new RequestInfo("register", 223, 11234));
    collector.recordRequest(new RequestInfo("register", 323, 12334));
    collector.recordRequest(new RequestInfo("login", 23, 12434));
    collector.recordRequest(new RequestInfo("login", 1223, 14234));
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testEmailReporter() {
    MetricsStorage storage = new MockRedisMetricsStorage();
    Aggregator aggregator = new Aggregator();
    ConsoleReporter consoleReporter = new ConsoleReporter(new ConsoleViewer(), aggregator, storage);
    consoleReporter.startRepeatedReport(2, 2);
    MetricsCollector collector = new MetricsCollector(storage);
    collector.recordRequest(new RequestInfo("register", 123, 10234));
    collector.recordRequest(new RequestInfo("register", 223, 11234));
    collector.recordRequest(new RequestInfo("register", 323, 12334));
    collector.recordRequest(new RequestInfo("login", 23, 12434));
    collector.recordRequest(new RequestInfo("login", 1223, 14234));
  }
}