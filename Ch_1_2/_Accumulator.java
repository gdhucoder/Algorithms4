package Ch_1_2;

/**
 * Created by HuGuodong on 2019/6/14.
 */

public class _Accumulator {

  private int N;
  private double sum;

  public _Accumulator() {

  }

  public void addDataValue(double val) {
    N++;
    sum += val;
  }

  public double mean() {
    return sum / N;
  }

  public String toString() {
    return String.format("Mean (%d values):%7.5f\n", N, mean());
  }
}
