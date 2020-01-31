package designpattern.u39.viewer;

import designpattern.u39.RequestStat;
import java.util.Map;

/**
 * Created by HuGuodong on 1/31/20.
 */
public interface StatViewer {

  void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills);
}
