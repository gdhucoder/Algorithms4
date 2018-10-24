package edu.princeton.cs.myalg.u2.u2_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.myalg.u2.u2_1.SortUtil;
import java.awt.Color;

/**
 * Created by HuGuodong on 2018/8/7.
 */

public class MergeSort {

  private static boolean PRINT_TRACE_2_2_1 = false;
  private static boolean PRINT_TRACE_2_2_2 = false;

  private static Comparable[] aux;

  public static void sort(Comparable[] a) {

    aux = new Comparable[a.length]; // 初始化数组
    sort(a, 0, a.length - 1);
    assert isSorted(a);
  }

  private static void sort(Comparable[] a, int lo, int hi) {

    if (hi <= lo) {
      return;
    }

    int mid = lo + (hi - lo) / 2;

    sort(a, lo, mid);
    sort(a, mid + 1, hi);
    merge(a, lo, mid, hi);
//    SortUtil.show(a, lo, hi);

    if (PRINT_TRACE_2_2_2) {
      StdOut.printf("merge(a,%2d,%2d,%2d) ", lo, mid, hi);
      show(a);
    }
  }

  public static void merge(Comparable[] a, int lo, int mid, int hi) {

    StdOut.printf("%d,", hi-lo+1);
    int i = lo, j = mid + 1;

    if (aux == null) {
      aux = new Comparable[a.length];
    }

    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    if (PRINT_TRACE_2_2_1) {
      StdOut.printf("%4s ", "k");
      show(a, 0, a.length - 1);
      StdOut.printf("%4s %4s \n", "i", "j");
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

  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  private static void show(Comparable[] a, int start, int end) {
    for (int i = start; i <= end; i++) {
      StdOut.print(a[i] + " ");
    }
    for (int i = end; i <= a.length; i++) {
      StdOut.print(" " + " ");
    }

  }


  private static void show(Comparable[] a, int lo, int mid, int hi, int idx_i, int idx_j) {

    Comparable position = " ";
    for (int i = lo; i <= hi; i++) {

      if (i >= idx_i && i < mid + 1) {
        position = a[i];
      } else if (i >= idx_j && i <= hi) {
        position = a[i];
      } else {
        position = " ";

      }
      if (i == mid + 1) {
        StdOut.print("|");
      }
      StdOut.print(position + " ");
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
//    String[] a = StdIn.readAllStrings();
    Double[] a = SortUtil.genDoubleArray(39);
    sort(a);
    assert isSorted(a);
//    show(a);
  }

}
