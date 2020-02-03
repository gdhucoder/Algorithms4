package designpattern.u40.factory;

import designpattern.u40.Aggregator;
import designpattern.u40.reporter.ConsoleReporter;
import designpattern.u40.storage.MetricsStorage;
import designpattern.u40.viewer.ConsoleViewer;

/**
 * Created by HuGuodong on 1/31/20.
 */
public class ReporterFactory {


  public static ConsoleReporter createConsoleReporter(MetricsStorage storage) {
    Aggregator aggregator = new Aggregator();
    return new ConsoleReporter(new ConsoleViewer(), aggregator, storage);
  }


}
