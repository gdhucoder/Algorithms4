package edu.princeton.cs.myalg.u2.u2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.awt.Color;

/**
 * Created by HuGuodong on 2018/8/15.
 */

public class SortUtil {

  public static Double[] genDoubleArray(int length) {
    Double[] a = new Double[length];
    for (int i = 0; i < length; i++) {
      a[i] = StdRandom.uniform();
    }

    return a;
  }

  public static void show(Comparable[] a, int start, int end) {
    StdDraw.enableDoubleBuffering();
    StdDraw.setYscale(0.0, 2);
    StdDraw.clear(Color.WHITE);
    int N = a.length;

    for (int i = 0; i < N; i++) {

      double x = 1.0 * i / N;
      double y = (double) a[i] / 2.0;
      double rw = 0.3 / N;
      double rh = (double) a[i] / 2.0;
      if (i <= end && i >= start) {
        StdDraw.setPenColor(StdDraw.BLACK);
      } else {
        StdDraw.setPenColor(Color.GRAY);
      }
      StdDraw.filledRectangle(x, y, rw, rh);

      StdDraw.show();
      StdDraw.pause(50);
    }
  }

}
