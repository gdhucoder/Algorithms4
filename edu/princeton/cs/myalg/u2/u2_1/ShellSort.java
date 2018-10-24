package edu.princeton.cs.myalg.u2.u2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.awt.Color;

/**
 * Created by HuGuodong on 2018/7/23.
 */

public class ShellSort {

  public static void sort(Comparable[] a) {
    int N = a.length;
    int h = 1;
    while (h < N/3){
      h = 3*h + 1;
    }
    while(h>=1){
      for(int i=h; i<N; i++){
        for(int j=i; j>=h && less(a[j],a[j-h]); j-=h){
          exch(a, j, j-h);
        }
      }
      h /= 3;
    }
    assert isSorted(a);
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

  private static void show(Comparable[] a, int sorted, int min) {
    StdDraw.enableDoubleBuffering();
    StdDraw.setYscale(0.0, 2);
    StdDraw.clear(Color.WHITE);
    int N = a.length;

    for (int i = 0; i < N; i++) {

      double x = 1.0 * i / N;
      double y = (double) a[i] / 2.0;
      double rw = 0.3 / N;
      double rh = (double) a[i] / 2.0;
      if (i <= sorted && i > min) {
        StdDraw.setPenColor(StdDraw.BLACK);
      } else if (i == min) {
        System.out.println(a[i]);
        StdDraw.setPenColor(Color.RED);
      } else {
        StdDraw.setPenColor(Color.GRAY);
      }
      StdDraw.filledRectangle(x, y, rw, rh);

      StdDraw.show();
      StdDraw.pause(50);
    }
//    StdDraw.clear();
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
