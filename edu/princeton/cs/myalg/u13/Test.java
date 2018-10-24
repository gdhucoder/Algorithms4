package edu.princeton.cs.myalg.u13;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Created by HuGuodong on 2018/5/14.
 */

public class Test {

  public static void main(String[] args) {
    System.out.println(( 0 + 15 ) / 2 );
    System.out.println(2.0e-6 * 100000000.1);
    System.out.println(true && false || true && true);
    System.out.println(Math.abs(-2147483648));
    System.out.println(-1.0/0.0);
    int N = 100;
    StdDraw.setXscale(0, N);
    StdDraw.setYscale(0, N * N);
    StdDraw.setPenRadius(.01);
    for (int i = 1; i <= N; i++) {
      StdDraw.point(i, i);
      StdDraw.point(i, i * i);
      StdDraw.point(i, i * Math.log(i));
    }
  }

}
