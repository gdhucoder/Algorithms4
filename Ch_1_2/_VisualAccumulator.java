package Ch_1_2;

import edu.princeton.cs.algs4.StdDraw;

/**
 * 可视化累加器
 * Created by HuGuodong on 2019/6/14.
 */

public class _VisualAccumulator {

  private int N;
  private double sum;

  public _VisualAccumulator(int trials, double max) {
    StdDraw.setXscale(0, trials);
    StdDraw.setYscale(0, max);
    StdDraw.setPenRadius(0.005);
  }

  public void addDataValue(double val) {
    N++;
    sum += val;
    StdDraw.setPenColor(StdDraw.DARK_GRAY);
    StdDraw.point(N, val);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.point(N, sum / N);
  }

  public double mean() {
    return sum / N;
  }

  public String toString() {
    return String.format("Mean (%d values):%7.5f\n", N, mean());
  }
}

