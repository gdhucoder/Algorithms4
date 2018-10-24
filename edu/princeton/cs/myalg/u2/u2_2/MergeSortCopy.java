package edu.princeton.cs.myalg.u2.u2_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/8/7.
 */

public class MergeSortCopy {

  private static boolean PRINT_TRACE_2_2_1 = false;
  private static boolean PRINT_TRACE_2_2_2 = true;

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

    if (PRINT_TRACE_2_2_2) {
      StdOut.printf("merge(a, %d, %d, %d) \n", lo, mid, hi);
    }
  }

  public static void merge(Comparable[] a, int lo, int mid, int hi) {
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

    for (int k = 0; k <= hi; k++) {
      boolean getFromLo = false;
      boolean getFromHi = false;
      if (i > mid) {
        a[k] = aux[j++];
        getFromHi = true;
      } else if (j > hi) {
        a[k] = aux[i++];
        getFromLo = true;
      } else if (less(aux[j], aux[i])) {
        a[k] = aux[j++];
        getFromHi = true;
      } else {
        a[k] = aux[i++];
        getFromLo = true;
      }

      if (PRINT_TRACE_2_2_1) {
        StdOut.printf("%4d ", k);
        show(a, 0, k);
        StdOut.printf("%4d %4d \t", i, j);
        if (getFromLo) {
          show(aux, lo, mid, hi, i - 1, j);
        } else {
          show(aux, lo, mid, hi, i, j - 1);
        }
        StdOut.println();
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
    String[] a = StdIn.readAllStrings();
    sort(a);
    assert isSorted(a);
    show(a);
  }

}
