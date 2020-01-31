package designpattern.u39.storage;

import designpattern.u39.RequestInfo;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by HuGuodong on 1/31/20.
 */
public class RedisMetricsStorage implements MetricsStorage {

  //...省略属性和构造函数等...
  @Override
  public void saveRequestInfo(RequestInfo requestInfo) {
    //...
    System.out.println("saveRequestInfo");
  }

  @Override
  public List<RequestInfo> getRequestInfos(String apiName, long startTimestamp, long endTimestamp) {
    //...
    System.out.println("getRequestInfos");
    return Collections.emptyList();
  }

  @Override
  public Map<String, List<RequestInfo>> getRequestInfos(long startTimestamp, long endTimestamp) {
    //...
    System.out.println("getRequestInfos");
    return null;
  }
}