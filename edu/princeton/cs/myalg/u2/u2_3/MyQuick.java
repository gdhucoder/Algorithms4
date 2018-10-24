package edu.princeton.cs.myalg.u2.u2_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

/**
 * Created by HuGuodong on 2018/9/12.
 */

public class MyQuick {

  public static void sort(Comparable[] a) {
//    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
    assert isSorted(a);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int j = partition(a, lo, hi);

    StdOut.printf("%2d %2d %2d ", lo, j, hi);
    show(a);

    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
    assert isSorted(a, lo, hi);
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi + 1;
    Comparable v = a[lo];
    while (true) {
      while (less(a[++i], v)) {
        if (i == hi) {
          break;
        }
      }

      while (less(v, a[--j])) {
        if (j == lo) {
          break;
        }
      }
      // check if pointers cross
      if (i >= j) {
        break;
      }

      exch(a, i, j);
    }
    // put partitioning item v at a[j]
    exch(a, lo, j);

    return j;
  }

  private static void exch(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  private static boolean less(Comparable v, Comparable w) {
    if (v == w) {
      return false;
    }
    return v.compareTo(w) < 0;
  }


  private static boolean isSorted(Comparable[] a) {
    return isSorted(a, 0, a.length - 1);
  }

  private static boolean isSorted(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  public static void show(Comparable[] a) {
    for (Comparable ele : a) {
      StdOut.print(ele + "\t\t");
    }
    StdOut.println();
  }

  @Test
  public void Q1(){
    String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
    partition(a, 0, a.length -1);
    show(a);
  }

  @Test
  public void Q2(){
    String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
    sort(a);
    show(a);
  }




  public static void main(String[] args) {
    Integer[] a = new Integer[10];
    for (int i = 0; i < 10; i++) {
      a[i] = StdRandom.uniform(100);
    }

    sort(a);
    show(a);



  }

}
