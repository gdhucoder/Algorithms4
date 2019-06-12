package Ch_1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2019/6/12.
 */

public class _Interval2D {

  public static void main(String[] args) {
    double xlo = Double.parseDouble(args[0]);
    double xhi = Double.parseDouble(args[1]);
    double ylo = Double.parseDouble(args[2]);
    double yhi = Double.parseDouble(args[3]);
    int T = Integer.parseInt(args[4]);

    Interval1D xinterval = new Interval1D(xlo, xhi);
    Interval1D yinterval = new Interval1D(ylo, yhi);
    Interval2D box = new Interval2D(xinterval, yinterval);
    box.draw();
    _Counter counter = new _Counter("hits");
    for (int t = 0; t < T; t++) {
      double x = StdRandom.uniform();
      double y = StdRandom.uniform();
      Point2D p = new Point2D(x, y);
      if(box.contains(p)){
        counter.increment();
      }else {
        p.draw();
      }
    }

    StdOut.println(counter);
    StdOut.printf("box area = %.2f\n", box.area());
//    .2 .5 .5 .6 10000
//    292 hits
//    box area = 0.03
  }
}
