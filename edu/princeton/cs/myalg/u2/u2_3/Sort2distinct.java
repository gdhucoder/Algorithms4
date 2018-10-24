package edu.princeton.cs.myalg.u2.u2_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Assumes there are at most 2 distinct elements
 * Created by HuGuodong on 2018/9/18.
 */

public class Sort2distinct {

  private static void sort(Comparable[] a) {
    int lt = 0, gt = a.length - 1;
    int i = 0;
    while (i <= gt) {
      int cmp = a[i].compareTo(a[lt]);
      if (cmp < 0) {
        exch(a, lt++, i++);
      } else if (cmp > 0) {
        exch(a, i, gt--);
      } else {
        i++;
      }
    }

  }

  // exchange a[i] and a[j]
  private static void exch(Object[] a, int i, int j) {
    Object o = a[i];
    a[i] = a[j];
    a[j] = o;
  }

  public static void main(String[] args) {

    // command-line argument as array
    String s = "100001111000111101010";
    int n = s.length();
    String[] a = new String[s.length()];
    for (int i = 0; i < n; i++) {
      a[i] = s.substring(i, i + 1); // indexOf 返回的是char类型
    }
    // sort a print results
    sort(a);
    for (int i = 0; i < n; i++) {
      StdOut.print(a[i]);
    }
    StdOut.println();
    // 000000000011111111111

  }


}
