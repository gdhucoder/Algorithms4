package edu.princeton.cs.myalg.u2.u2_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.ArrayList;

/**
 * Created by HuGuodong on 2018/8/6.
 */

public class Ex_2_1_12 {

  static int count = 0;


  public static void sort(Comparable[] a) {
    int N = a.length;
    int h = 1;
    ArrayList<Integer> hlist = new ArrayList<>();
    hlist.add(h);
    while (h < N / 3) {
      h = 3 * h + 1;
      hlist.add(h);
    }

    StdOut.printf("For array length = %10d, N^(1/5): %.2f \n",N, Math.pow(N,0.2));
    for (int k = hlist.size() - 1; k >= 0; k--) {
      count = 0;
      int H = hlist.get(k);
      // 比较次数
      int arraySize = 0;
      for (int i = H; i < N; i++) {
        arraySize++;
        for (int j = i; j >= H && less(a[j], a[j - H]); j -= H) {
          exch(a, j, j - H);
        }
      }
      StdOut.printf("h: %10d \t %10.2f \n",H, (double) count /N);
    }
    StdOut.println();
  }

  private static boolean less(Comparable v, Comparable w) {
    count ++ ;
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

  public static Comparable[] randomInput(int N) {
    // Use alg to sort T random arrays of length N
    Double[] a = new Double[N];
      for (int i = 0; i < N; i++) {
        a[i] = StdRandom.uniform();
    }
    return a;
  }


  public static void main(String[] args) {
    int size = 100;
    int MAX = 5;
    for(int i=1; i<=MAX; i++){
      size *= 10;
      sort(randomInput(size));
    }
  }

}
