package designpattern.u39;

/**
 * Created by HuGuodong on 1/31/20.
 */
public class RequestInfo {

  private String apiName;
  private double responseTime;
  private long timestamp;
  //...省略constructor/getter/setter方法...


  public RequestInfo(String apiName, double responseTime, long timestamp) {
    this.apiName = apiName;
    this.responseTime = responseTime;
    this.timestamp = timestamp;
  }

  public String getApiName() {
    return apiName;
  }

  public void setApiName(String apiName) {
    this.apiName = apiName;
  }

  public double getResponseTime() {
    return responseTime;
  }

  public void setResponseTime(double responseTime) {
    this.responseTime = responseTime;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}