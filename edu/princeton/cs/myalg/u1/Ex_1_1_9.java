package edu.princeton.cs.myalg.u1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/5/15.
 */

public class Ex_1_1_9 {

  /**
   * Write a code fragment that puts the binary representation of a positive integer N into a String
   * s.
   */
  public static void main(String[] args) {
    int N = 2; // 10
    String s = "";

    for (int n = N; n > 0; n /= 2) {
      s = (n % 2) + s;
    }

    StdOut.println(s);
  }

}
