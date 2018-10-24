package edu.princeton.cs.myalg.u1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/5/15.
 */

public class Ex_1_1_7 {

  public static void main(String[] args) {

    // a
    double t = 9.0;
    while (Math.abs(t - 9.0 / t) > .001) {
      t = (9.0 / t + t) / 2.0;
    }
    StdOut.printf("%.5f\n", t);

    // b
    int sum = 0;
    for (int i = 1; i < 1000; i++) {
      for (int j = 0; j < i; j++) {
        sum++;
      }
    }
    StdOut.println(sum);

    sum = 0;
    for (int i = 1; i < 1000; i *= 2) {
      for (int j = 0; j < i; j++) {
        sum++;
      }
    }
    StdOut.println(sum);

  }
}
