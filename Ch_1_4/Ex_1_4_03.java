package Ch_1_4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.awt.Color;

/**
 * Created by HuGuodong on 2019/8/10.
 */

public class Ex_1_4_03 {

  public static double timeTrial(int N) {
    int MAX = 1000000;
    int[] a = new int[N];
    for (int i = 0; i < N; i++) {
      a[i] = StdRandom.uniform(-MAX, MAX);
    }
    _Stopwatch timer = new _Stopwatch();
//    int cnt = _ThreeSum.count(a);
    int cnt = _ThreeSum.count(a);
    return timer.elapsedTime();
  }

  public static void drawLogLog(int N) {
    StdDraw.setCanvasSize(200, 600);
    StdDraw.setXscale(Math.log(128), Math.log(N));
    StdDraw.setYscale(-10, 10);
    double x0 = 0;
    double y0 = 0;
    for (int n = 250; n <= N; n += n) {
      double time = timeTrial(n);
      StdOut.printf("%7d %5.1f\n", n, time);
      double x1 = Math.log(n);
      double y1 = Math.log(time);
      StdDraw.setPenRadius(0.01);
      StdDraw.setPenColor(Color.RED);
      StdDraw.point(x1, y1);
      if (x0 == 0 && y0 == 0) {

      } else {
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.line(x0, y0, x1, y1);
      }
      x0 = x1;
      y0 = y1;
    }
  }

  public static void drawStandard(int N) {
    StdDraw.setCanvasSize(400, 400);
    StdDraw.setXscale(0, 10000);
    StdDraw.setYscale(0, 100);
    double x0 = 0;
    double y0 = 0;
    for (int n = 250; n <= N; n += n) {
      double time = timeTrial(n);
      StdOut.printf("%7d %5.1f\n", n, time);
      double x1 = n;
      double y1 = time;
      StdDraw.setPenRadius(0.01);
      StdDraw.setPenColor(Color.RED);
      StdDraw.point(x1, y1);
      if (x0 == 0 && y0 == 0) {

      } else {
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.line(x0, y0, x1, y1);
      }
      x0 = x1;
      y0 = y1;
    }
  }

  public static void main(String[] args) {
    int N = 100000;
//    drawLogLog(N);
    drawStandard(N);

    // N^3
//    250   0.0
//    500   0.1
//    1000   0.6
//    2000   3.9
//    4000  22.8
//    8000 184.8
//    16000 1609.8

    // N^2logN
//    250   0.0
//    500   0.0
//    1000   0.0
//    2000   0.1
//    4000   0.6
//    8000   2.5
//    16000   8.6
//    32000  36.0

  }
}
