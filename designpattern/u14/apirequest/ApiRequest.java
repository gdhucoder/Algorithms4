package designpattern.u14.apirequest;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by HuGuodong on 12/4/19.
 */
public class ApiRequest {

  private String baseUrl;
  private String appID;
  private long timeStamp;
  private String token;

  public ApiRequest(String fullUrl) {

    Map<String, String> params = parse(fullUrl);
    // TODO
    String baseUrl = "";
    String appID = "";
    long timeStamp = 0L;
    String token = "";
  }

  public static ApiRequest genFakeReq(String fullUrl) {
    ApiRequest req = new ApiRequest("geekbang", "designpattern", new Date().getTime(),
        "IXIGIpJ9hdOBCyjStaDJ5Nom07g=");
    return req;
  }

  private static Map<String, String> parse(String fullUrl) {
    Map<String, String> params = new TreeMap<>();
    // TODO
    return params;
  }


  public ApiRequest(String baseUrl, String appID, long timeStamp, String token) {
    this.baseUrl = baseUrl;
    this.appID = appID;
    this.timeStamp = timeStamp;
    this.token = token;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public String getAppID() {
    return appID;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  public String getToken() {
    return token;
  }
}
