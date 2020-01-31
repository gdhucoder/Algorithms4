package designpattern.u39.factory;

import designpattern.u39.Aggregator;
import designpattern.u39.reporter.ConsoleReporter;
import designpattern.u39.storage.MetricsStorage;
import designpattern.u39.viewer.ConsoleViewer;

/**
 * Created by HuGuodong on 1/31/20.
 */
public class ReporterFactory {


  public static ConsoleReporter createConsoleReporter(MetricsStorage storage) {
    Aggregator aggregator = new Aggregator();
    return new ConsoleReporter(storage, aggregator, new ConsoleViewer());
  }


}
