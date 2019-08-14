package Ch_1_4;

import edu.princeton.cs.algs4.StdOut;

public class _DoublingRatio {

  public static double timeTrial(int n) {
    return _ThreeSumDoublingTest.timeTrial(n);
  }

  public static void main(String[] args) {
    double prev = timeTrial(125);
    for (int n = 250; true; n += n) {
      double time = timeTrial(n);
      StdOut.printf("%6d, %7.1f", n, time);
      StdOut.printf("%5.1f\n", time / prev);
      prev = time;
    }
//        250,     0.0  1.0
//        500,     0.0  3.0
//        1000,     0.0  2.7
//        2000,     0.1  4.1
//        4000,     0.3  4.1
//        8000,     1.1  3.9
//        16000,     4.2  4.0
//        32000,    17.9  4.2
  }
}
