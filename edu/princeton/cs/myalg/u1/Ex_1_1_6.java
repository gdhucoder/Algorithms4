package edu.princeton.cs.myalg.u1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/5/15.
 */

public class Ex_1_1_6 {

  /**
   * a(i) = a(i-1) + a(i-2)
   * @param args
   */
  public static void main(String[] args) {
    int f = 0;
    int g = 1;
    for (int i = 0; i <= 15; i++) {
      StdOut.println(f);
      f = f + g;
      g = f - g;
    }
  }

}
