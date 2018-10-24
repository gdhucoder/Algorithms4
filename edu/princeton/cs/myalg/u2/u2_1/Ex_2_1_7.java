package edu.princeton.cs.myalg.u2.u2_1;

import static edu.princeton.cs.myalg.u2.u2_1.SortCompare.timeReverseOrderInput;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/7/31.
 */

public class Ex_2_1_7 {

  public static void main(String[] args) {
    String alg1 = args[0];
    String alg2 = args[1];
    int N = Integer.parseInt(args[2]);
    int T = Integer.parseInt(args[3]);
    long t1 = timeReverseOrderInput(alg1, N, T);
    long t2 = timeReverseOrderInput(alg2, N, T);
    StdOut.printf("For %d Reverser Order Array\n \t %s is", N, alg1);
    StdOut.printf(" %.2f times faster than %s\n", (0.0 + t2) / (0.0+ t1), alg2);

  }

}
