package Ch_1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2019/5/5.
 */

public class Ex_1_1_31 {

  /**
   * drawCircleConnection
   *
   * @param N num of dots
   */
  public static void drawCircleConnection(int N, double p) {

    // canvas & scale
    StdDraw.setCanvasSize(640, 640);
    StdDraw.setScale(-1.2, 1.2);

    // draw a circle at (0,0) and radius = 1
    StdDraw.circle(0, 0, 1);

    // pen radius
    StdDraw.setPenRadius(0.05);

    // N points on circle
    double[][] points = new double[N][2];
    for (int i = 0; i < N; i++) {
      double x_pos = Math.cos(2 * Math.PI * i / N);
      double y_pos = Math.sin(2 * Math.PI * i / N);

      StdDraw.point(x_pos, y_pos);

      // save points
      points[i][0] = x_pos;
      points[i][1] = y_pos;
    }

    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.setPenRadius(); // default line width
    for (int i = 0; i < N; i++)
      for (int j = i + 1; j < N; j++)
        if (StdRandom.bernoulli(p))
          // x_form, y_from -> x_to, y_to
          StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]);

  }

  public static void main(String[] args) {
    int N = 20; // N points
    double p = 0.1; // prob of connection between 2 points
    drawCircleConnection(N, p);
  }
}
