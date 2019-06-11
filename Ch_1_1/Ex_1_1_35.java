package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/6/12.
 */

public class Ex_1_1_35 {

  public static double[] exactDiceProb() {
    int SIDES = 6;
    double[] dist = new double[2 * SIDES + 1];
    for (int i = 1; i <= SIDES; i++) {
      for (int j = 1; j <= SIDES; j++) {
        dist[i + j] += 1.0;
      }
    }
    for (int i = 2; i <= 2 * SIDES; i++) {
      dist[i] /= 36;
    }
    return dist;
  }

  public static double[] runSimDiceProb(int N) {
    int SIDES = 6;
    double[] dist = new double[2 * SIDES + 1];
    for (int i = 0; i < N; i++) {
      int rollNum1 = StdRandom.uniform(1, SIDES + 1);
      int rollNum2 = StdRandom.uniform(1, SIDES + 1);
      dist[rollNum1 + rollNum2] += 1.0;
    }
    for (int i = 2; i <= 2 * SIDES; i++) {
      dist[i] /= N;
    }
    return dist;
  }

  public static void show(double[] prob) {
    for (int i = 2; i < prob.length; i++) {
      StdOut.printf("%d -> %.3f\n", i, prob[i]);
    }
  }

  public static void changePrecision(double[] a, int digits) {
    int N = (int) (Math.pow(10, digits));
    for (int i = 0; i < a.length; i++) {
      a[i] = ((double)Math.round(a[i] * N)) / N;
    }
  }

  public static boolean compare(double[] a, double[] b) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    double[] exactProb = exactDiceProb();
    show(exactProb);
    changePrecision(exactProb, 3);
    PrintUtil.show(exactProb);
    double[] simProb;
    for (int i = 100; i < 1000000000; i *= 10) {
      simProb = runSimDiceProb(i);
      changePrecision(simProb, 3);
      boolean isEqual = compare(exactProb, simProb);
      if (isEqual) {
        StdOut.printf("sim %d rolls\n", i);
        show(simProb);
        break;
      }
    }
//    sim 1000000 rolls
//    2 -> 0.028
//    3 -> 0.056
//    4 -> 0.083
//    5 -> 0.111
//    6 -> 0.139
//    7 -> 0.167
//    8 -> 0.139
//    9 -> 0.111
//    10 -> 0.083
//    11 -> 0.056
//    12 -> 0.028

  }
}
