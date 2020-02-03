package designpattern.u40.viewer;

import com.google.gson.Gson;
import designpattern.u40.RequestStat;
import java.util.Map;

/**
 * Created by HuGuodong on 1/31/20.
 */
public class ConsoleViewer implements StatViewer {

  @Override
  public void output(Map<String, RequestStat> requestStats, long startTimeInMillis,
      long endTimeInMillis) {
    System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
    Gson gson = new Gson();
    System.out.println(gson.toJson(requestStats));
  }
}
