package Ch_1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2019/6/17.
 */

public class Ex_1_2_01 {

  public static void minDist(int N) {

    // draw points
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(0.1);
    Point2D[] points = new Point2D[N];
    for (int i = 0; i < N; i++) {
      points[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
      points[i].draw();
    }
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setPenRadius(0.005);
    double minDist = Double.MAX_VALUE;
    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        Point2D p_i = points[i];
        Point2D p_j = points[j];
        double dis = p_j.distanceTo(p_i);
        p_j.drawTo(p_i);

        // draw distance
        StdDraw.text((p_j.x()+ p_i.x())/2, (p_j.y()+ p_i.y())/2, String.format("%.3f", dis));

        //
        StdOut.printf("%d %d %.3f\n", i, j, dis);
        if (dis < minDist) {
          minDist = dis; // min distance
        }
      }
    }
    StdOut.printf("Min distance is %.3f\n", minDist);
  }

  public static void main(String[] args) {
    int N = 5; // generates 5 pts
    minDist(N);
//    0 1 0.407
//    0 2 0.838
//    0 3 0.936
//    0 4 0.423
//    1 2 0.432
//    1 3 0.647
//    1 4 0.109
//    2 3 0.505
//    2 4 0.453
//    3 4 0.740
//    Min distance is 0.109

  }

}
