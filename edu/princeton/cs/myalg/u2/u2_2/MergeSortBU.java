package edu.princeton.cs.myalg.u2.u2_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/8/15.
 */

public class MergeSortBU {

  private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    int N = a.length;
    aux = new Comparable[N];
    for (int sz = 1; sz < N; sz = sz + sz) {
      for (int lo = 0; lo < N - sz; lo += sz + sz) {
        merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
        StdOut.printf("size = %2d, merge(a, %2d, %2d, %2d) ", sz, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
        show(a);
        StdOut.println();
      }
    }
    System.out.println(1);
    assert isSorted(a);

  }

  public static void merge(Comparable[] a, int lo, int mid, int hi) {
    int i = lo, j = mid + 1;

    if (aux == null) {
      aux = new Comparable[a.length];
    }

    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (less(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }

  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Object[] a, int i, int j) {
    Object t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + "\t");
    }
  }


  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

  }


}
