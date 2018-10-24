package edu.princeton.cs.myalg.u2.u2_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HuGuodong on 2018/7/18.
 */

public class SortCompare {

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

    if (alg.equals("ShellSort-Arr")) {
      Ex_2_1_11.sort(a);
    }
    // seconds
    long now = System.currentTimeMillis();
    return now - time;
  }

  public static long timeRandomInput(String alg, int N, int T) {
    // Use alg to sort T random arrays of length N
    long total = 0;
    Double[] a = new Double[N];
    for (int t = 0; t < T; t++) {
      for (int i = 0; i < N; i++) {
        a[i] = StdRandom.uniform();
      }
      total = +time(alg, a);
    }
    return total;
  }

  /**
   * 生成反序数组，比较算法。
   * @param alg
   * @param N
   * @param T
   * @return
   */
  public static long timeReverseOrderInput(String alg, int N, int T) {
    // Use alg to sort T random arrays of length N
    long total = 0;
    Double[] a = new Double[N];
    for (int t = 0; t < T; t++) {
      for (int i = 0; i < N; i++) {
        a[i] = 0.0 + N - i; // 这样就是反序数组了
      }
      total = +time(alg, a);
    }
    return total;
  }


  public static void main(String[] args) {
    String alg1 = args[0];
    String alg2 = args[1];
    int N = Integer.parseInt(args[2]);
    int T = Integer.parseInt(args[3]);
    long t1 = timeRandomInput(alg1, N, T);
    long t2 = timeRandomInput(alg2, N, T);
    StdOut.printf("For %d random Doubles\n \t %s is", N, alg1);
    StdOut.printf(" %.2f times faster than %s\n", (0.0 + t2) / t1, alg2);

  }

}
