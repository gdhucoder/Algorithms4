package edu.princeton.cs.myalg.u2.u2_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/8/7.
 */

public class Ex_2_2_1 {

  public static void main(String[] args) {
    // A E Q S U Y E I N O S T
    // E E G M R A C E R T
    String[] a = args;
    int lo = 0;
    int mid = (a.length - 1)/2;
    int hi = a.length - 1;
    MergeSort.merge(a, lo, mid, hi);
  }

}
