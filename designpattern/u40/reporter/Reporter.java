package designpattern.u40.reporter;

import designpattern.u40.Aggregator;
import designpattern.u40.RequestInfo;
import designpattern.u40.RequestStat;
import designpattern.u40.storage.MetricsStorage;
import designpattern.u40.viewer.StatViewer;
import java.util.List;
import java.util.Map;

/**
 * Created by HuGuodong on 2/3/20.
 */
public abstract class Reporter {

  protected StatViewer viewer;
  protected Aggregator aggregator;
  protected MetricsStorage metricsStorage;


  public Reporter(StatViewer viewer, Aggregator aggregator,
      MetricsStorage metricsStorage) {
    this.viewer = viewer;
    this.aggregator = aggregator;
    this.metricsStorage = metricsStorage;
  }

  public void doReport(long startTimeInMillis, long endTimeInMillis) {
    long durationInMillis = endTimeInMillis - startTimeInMillis;
    Map<String, List<RequestInfo>> requestInfos =
        metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
    Map<String, RequestStat> stats = aggregator
        .aggregate(requestInfos, durationInMillis);
    // console output
    viewer.output(stats, startTimeInMillis, endTimeInMillis);
  }
}
