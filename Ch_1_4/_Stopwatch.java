package Ch_1_4;

/**
 * Created by HuGuodong on 2019/8/6.
 */

public class _Stopwatch {

  private final long start;

  public _Stopwatch() {
    start = System.currentTimeMillis();
  }

  public double elapsedTime() {
    long now = System.currentTimeMillis();
    return (now - start) / 1000.0;
  }
}
