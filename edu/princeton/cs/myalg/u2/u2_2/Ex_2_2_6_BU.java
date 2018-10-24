package edu.princeton.cs.myalg.u2.u2_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.myalg.u2.u2_1.SortUtil;

/**
 * Created by HuGuodong on 2018/9/3.
 */

public class Ex_2_2_6_BU {

  private static int compareTimes;

  private static Comparable[] aux;


  public static void sort(Comparable[] a) {
    int N = a.length;
    aux = new Comparable[N];
    for (int sz = 1; sz < N; sz = sz + sz) {
      for (int lo = 0; lo < N - sz; lo += sz + sz) {
        merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
      }
    }
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

    // 1 copy
    int increment = (hi - lo + 1) * 2;
    compareTimes += increment;

    // 3 move back
    compareTimes += increment;

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
    // 2 compare
    compareTimes += 2;
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

    // 1 建立数组，长度分别为 2 4 8 16 ...
    // 2 根据不同长度的数组排序，返回一个比较次数
    // 3 作图：横轴：数组长度 纵轴：比较次数，比较次数的上限

    int temp = 1;
    int[] count = new int[9];
    int[] x = new int[9];
    for (int i = 1; i <= 9; i++) {
      temp *= 2;
      Double[] a = SortUtil.genDoubleArray(temp);
      compareTimes = 0;
      sort(a);
      x[i - 1] = temp;
      count[i - 1] = compareTimes;
      StdOut.println(temp + ": " + compareTimes);
      // 计算log以2为底！！
      StdOut.println(temp + ": " + 6 * temp * (Math.log(temp) / Math.log(2)));

    }

    Double[] a = SortUtil.genDoubleArray(39);
    sort(a);
    assert isSorted(a);
    show(a);
  }

}
