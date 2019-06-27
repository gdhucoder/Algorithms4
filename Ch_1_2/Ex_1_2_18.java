package Ch_1_2;

import edu.princeton.cs.algs4.StdOut;
import tools.ArrayGenerator;

/**
 * Created by HuGuodong on 2019/6/27.
 */

public class Ex_1_2_18 {

  public static class _Accumulator {

    private double m;
    private double s;
    private int N;

    public void addDataValue(double x) {
      N++;
      s = s + 1.0 * (N - 1) / N * (x - m) * (x - m); // 递推公式没太看懂
      m = m + (x - m) / N;
    }

    public double mean() {
      return m;
    }

    public double var() {
      return s / (N - 1); // 样本数减1
    }

    public double stddev() {
      return Math.sqrt(this.var());
    }
  }

  public static double normalMean(double[] a) {
    double sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    return sum / a.length;
  }

  public static double normalVar(double[] a) {
    double sum = 0;
    double mean = normalMean(a);
    for (int i = 0; i < a.length; i++) {
      sum += (a[i] - mean) * (a[i] - mean);
    }
    return sum / (a.length - 1);
  }


  public static void main(String[] args) {
    _Accumulator ac = new _Accumulator();

    double[] a = ArrayGenerator.randomDoubleArray(10, 10000);

    for (int i = 0; i < a.length; i++) {
      ac.addDataValue(a[i]);
    }
    StdOut.println(ac.mean());
    StdOut.println(ac.var());

    StdOut.println("===========================================");
    double mean = normalMean(a);
    double var = normalVar(a);
    StdOut.println(mean);
    StdOut.println(var);

//    5.032801250304476
//    8.239281563405298
//        ===========================================
//    5.032801250304482
//    8.239281563405308

  }
}
