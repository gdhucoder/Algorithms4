package edu.princeton.cs.myalg.u2.u2_1;


import static edu.princeton.cs.myalg.u2.u2_1.SortCompare.timeReverseOrderInput;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2018/7/31.
 */

public class Ex_2_1_8 {

  public static long time(String alg, Double[] a) {
    long time = System.currentTimeMillis();
    if (alg.equals("Insertion")) {
      Insertion.sort(a);
    }
    if (alg.equals("Selection")) {
      SelectionSort.sort(a);
    }
    if (alg.equals("ShellSort")) {
      ShellSort.sort(a);
    }
    // seconds
    long now = System.currentTimeMillis();
    return now - time;
  }

  public static long timeRandomInputThreeValues(String alg, int N, int T) {
    // Use alg to sort T random arrays of length N
    long total = 0;
    Double[] a = new Double[N];
    for (int t = 0; t < T; t++) {
      for (int i = 0; i < N; i++) {
        a[i] = 1.0 + StdRandom.uniform(4);
      }
      total = +time(alg, a);
    }
    return total;
  }

  public static void main(String[] args) {
    String alg1 = args[0];
    int N = Integer.parseInt(args[1]);
    int T = Integer.parseInt(args[2]);
    long t1 = timeRandomInputThreeValues(alg1, N, T);
    StdOut.printf("For %d 3-possible value Array\n \t %s is", N, alg1);
    StdOut.printf(" "+ t1 + "ms");
  }
}
