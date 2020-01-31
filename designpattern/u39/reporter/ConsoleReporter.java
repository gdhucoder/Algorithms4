package designpattern.u39.reporter;

import designpattern.u39.Aggregator;
import designpattern.u39.RequestInfo;
import designpattern.u39.RequestStat;
import designpattern.u39.storage.MetricsStorage;
import designpattern.u39.viewer.StatViewer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by HuGuodong on 1/31/20.
 */
public class ConsoleReporter {

  private MetricsStorage metricsStorage;
  private ScheduledExecutorService executor;
  private StatViewer viewer;
  private Aggregator aggregator;

  public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
    this.metricsStorage = metricsStorage;
    this.aggregator = aggregator;
    this.viewer = viewer;
    this.executor = Executors.newSingleThreadScheduledExecutor();
  }

  // 第4个代码逻辑：定时触发第1、2、3代码逻辑的执行；
  public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
    executor.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        // 第1个代码逻辑：根据给定的时间区间，从数据库中拉取数据；
        long durationInMillis = durationInSeconds * 1000;
        long endTimeInMillis = System.currentTimeMillis();
        long startTimeInMillis = endTimeInMillis - durationInMillis;
        Map<String, List<RequestInfo>> requestInfos =
            metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> stats = aggregator
            .aggregate(requestInfos, durationInMillis);
        // console output
        viewer.output(stats, startTimeInMillis, endTimeInMillis);
      }
    }, 0, periodInSeconds, TimeUnit.SECONDS);
  }
}