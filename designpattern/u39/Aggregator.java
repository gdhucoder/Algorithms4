package designpattern.u39;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HuGuodong on 1/31/20.
 */

public class Aggregator {

  public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfo,
      long durationInMillis) {
    Map<String, RequestStat> result = new HashMap<>();
    for (Map.Entry<String, List<RequestInfo>> entry : requestInfo.entrySet()) {
      String apiName = entry.getKey();
      List<RequestInfo> requestInfosPerApi = entry.getValue();
      // 第2个代码逻辑：根据原始数据，计算得到统计数据；
      RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
      result.put(apiName, requestStat);
    }
    return result;
  }


  public RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
    double maxRespTime = Double.MIN_VALUE;
    double minRespTime = Double.MAX_VALUE;
    double avgRespTime = -1;
    double p999RespTime = -1;
    double p99RespTime = -1;
    double sumRespTime = 0;
    long count = 0;
    for (RequestInfo requestInfo : requestInfos) {
      ++count;
      double respTime = requestInfo.getResponseTime();
      if (maxRespTime < respTime) {
        maxRespTime = respTime;
      }
      if (minRespTime > respTime) {
        minRespTime = respTime;
      }
      sumRespTime += respTime;
    }
    if (count != 0) {
      avgRespTime = sumRespTime / count;
    }
    long tps = (long) (count / durationInMillis * 1000);
    Collections.sort(requestInfos, new Comparator<RequestInfo>() {
      @Override
      public int compare(RequestInfo o1, RequestInfo o2) {
        double diff = o1.getResponseTime() - o2.getResponseTime();
        if (diff < 0.0) {
          return -1;
        } else if (diff > 0.0) {
          return 1;
        } else {
          return 0;
        }
      }
    });
    int idx999 = (int) (count * 0.999);
    int idx99 = (int) (count * 0.99);
    if (count != 0) {
      p999RespTime = requestInfos.get(idx999).getResponseTime();
      p99RespTime = requestInfos.get(idx99).getResponseTime();
    }
    RequestStat requestStat = new RequestStat();
    requestStat.setMaxResponseTime(maxRespTime);
    requestStat.setMinResponseTime(minRespTime);
    requestStat.setAvgResponseTime(avgRespTime);
    requestStat.setP999ResponseTime(p999RespTime);
    requestStat.setP99ResponseTime(p99RespTime);
    requestStat.setCount(count);
    requestStat.setTps(tps);
    return requestStat;
  }
}

