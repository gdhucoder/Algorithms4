package Ch_1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.awt.Color;

/**
 * Created by HuGuodong on 2019/6/17.
 */

public class Ex_1_2_03 {


  public static void show(int N, double min, double max) {

    StdDraw.setXscale(min, max);
    StdDraw.setYscale(min, max);
    Interval2D[] interval2DS = new Interval2D[N];
    for (int i = 0; i < N; i++) {
      double x1 = StdRandom.uniform(min, max);
      double x2 = StdRandom.uniform(x1, max);
      double y1 = StdRandom.uniform(min, max);
      double y2 = StdRandom.uniform(y1, max);
      StdOut.printf("%.3f %.3f %.3f %.3f\n", x1, x2, y1, y2);
      interval2DS[i] = new Interval2D(new Interval1D(x1, x2), new Interval1D(y1, y2));
      interval2DS[i].draw();
    }

    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        StdDraw.setPenColor(Color.RED);
        StdDraw.setPenRadius(0.01);
        if (interval2DS[i].intersects(interval2DS[j])) {
          interval2DS[i].draw();
          interval2DS[j].draw();
          StdOut.println("intersects: " + interval2DS[i] + " " + interval2DS[j]);
        }
      }
    }
  }


  //  Write an Interval2D client that takes command-line arguments N, min, and max and generates N random 2D intervals whose width and height are uniformly distributed between min and max in the unit square. Draw them on StdDraw and print the number of pairs of intervals that intersect and the number of intervals that are contained in one another.
  public static void main(String[] args) {
    int N = StdIn.readInt();
    double min = StdIn.readDouble();
    double max = StdIn.readDouble();

    show(N, min, max);

//    double x1 = 0.1;
//    double x2 = 0.2;
//    double y1 = 1;
//    Interval2D interval2D = new Interval2D(new Interval1D(x1, x2), new Interval1D(x1, y1));
//    interval2D.draw();
//
//    interval2D = new Interval2D(new Interval1D(x1, x2), new Interval1D(x2, 0.6));
//    StdDraw.setPenColor(Color.RED);
//    interval2D.draw();

//    input : 5 1 3
//    2.086 2.868 2.681 2.888
//    1.317 1.796 1.334 1.685
//    1.076 1.169 1.161 2.466
//    2.718 2.898 1.879 2.822
//    1.124 2.785 2.056 2.757
//    intersects: [2.085732774635417, 2.867627605042185] x [2.6812764408234657, 2.888416623450271] [2.717900071730835, 2.898131211101078] x [1.8787075417069883, 2.8223422183654305]
//    intersects: [2.085732774635417, 2.867627605042185] x [2.6812764408234657, 2.888416623450271] [1.1244512150893864, 2.7848273473246246] x [2.0561356585718746, 2.7572245972031375]
//    intersects: [1.076212020768767, 1.1691905904168232] x [1.1610568511465638, 2.466455232585124] [1.1244512150893864, 2.7848273473246246] x [2.0561356585718746, 2.7572245972031375]
//    intersects: [2.717900071730835, 2.898131211101078] x [1.8787075417069883, 2.8223422183654305] [1.1244512150893864, 2.7848273473246246] x [2.0561356585718746, 2.7572245972031375]

  }
}
