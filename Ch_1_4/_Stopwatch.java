package Ch_1_4;

/**
 * Created by HuGuodong on 2019/8/6.
 */

public class _Stopwatch {

  private long start;

  public _Stopwatch() {
    start = System.currentTimeMillis();
  }

  public double elapsedTime() {
    long now = System.currentTimeMillis();
    return (now - start) / 1000.0;
  }

  public long elapsedTimeLong() {
    return System.currentTimeMillis() - start;
  }

  public long start() {
    return start;
  }

  public void reset() {
    start = System.currentTimeMillis();
  }
}
