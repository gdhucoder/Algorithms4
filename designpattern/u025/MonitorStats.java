package designpattern.u025;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by HuGuodong on 12/30/19.
 */
public class MonitorStats {

  private Map<String, List<Long>> responseTimes = new HashMap<>();
  private Map<String, List<Long>> timestamps = new HashMap<>();
  private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

  public void recordResponseTime(String apiName, Long responseTime) {

  }

  public void recordResponseTimeStamp(String apiName, Long timestamp) {

  }

  public void startRepeatedReport(long period, TimeUnit timeUnit) {
    executor.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        Map<String, Map<String, Long>> stats = new HashMap<>();
        for (Map.Entry<String, List<Long>> entry : responseTimes.entrySet()) {
          String apiName = entry.getKey();
          List<Long> apiRespTimes = entry.getValue();
          stats.putIfAbsent(apiName, new HashMap<>());
          stats.get(apiName).put("max", max(apiRespTimes));
          stats.get(apiName).put("avg", avg(apiRespTimes));
        }

        for (Map.Entry<String, List<Long>> entry : timestamps.entrySet()) {
          String apiName = entry.getKey();
          List<Long> apiTimeStamps = entry.getValue();
          stats.putIfAbsent(apiName, new HashMap<>());
          stats.get(apiName).put("count", (long) apiTimeStamps.size());
        }
        // output
        System.out.println("stats: " + stats);
      }
    }, 0, period, timeUnit);
  }

  private Long min(List<Long> data) {
    return 0L;
  }

  public Long max(List<Long> data) {
    return 0L;
  }

  public Long avg(List<Long> data) {
    return 0L;
  }


}
