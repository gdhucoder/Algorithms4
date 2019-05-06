package Ch_1_1;

import static tools.ArrayGenerator.genRandomDoules;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.awt.Color;
import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/5/7.
 */

public class Ex_1_1_32 {

  public static void main(String[] args) {
//    int N = Integer.parseInt(args[0]);
//    double l = Double.parseDouble(args[1]);
//    double r = Double.parseDouble(args[2]);

    int N = 6;
    double l = 1.1;
    double r = 1000.1;
    double[] vals = genRandomDoules(1000, l, r);
    StdOut.println(Arrays.toString(vals));
    histogram(N, l, r, vals);
//    test();
  }

  public static void test() {
    int N = 50;
    double[] a = new double[N];
    for (int i = 0; i < N; i++) {
      a[i] = StdRandom.random();
    }
    for (int i = 0; i < N; i++) {
      double x = 1.0 * i / N;
      double y = a[i] / 2.0;
      double rw = 0.5 / N;
      double rh = a[i] / 2.0;
      StdDraw.filledRectangle(x, y, rw, rh);
    }
  }

  public static void histogram(int N, double l, double r, double[] vals) {
    StdDraw.setCanvasSize(512, 256);
    StdDraw.setXscale(l, r);
    StdDraw.setYscale(0, vals.length * 2 / 3);
    int[] freq = new int[N];
    double w = (r - l) / N;
    for (int i = 0; i < vals.length; i++) {
      int occurIdx = (int) ((vals[i] - l) / (r - l) * N);
      freq[occurIdx]++;
    }
    for (int i = 0; i < N; i++) {
      double x = l + w / 2.0 + w * i; //rectangle center (x)
      double y = freq[i] / 2.0;
      double rw = w / 4.0;
      double rh = freq[i] / 2.0;
      StdDraw.filledRectangle(x, y, rw, rh);
      StdDraw.text(x, 2 * y + 10, freq[i] + "");
    }

  }

}
