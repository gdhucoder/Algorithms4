package Ch_1_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.awt.Color;

/**
 * Created by HuGuodong on 2019/6/19.
 */

public class Ex_1_2_10 {

//  Develop a class VisualCounter that allows both increment and decrement operations. Take two arguments N and max in the constructor, where N specifies the maximum number of operations and max specifies the maximum absolute value for the counter. As a side effect, create a plot showing the value of the counter each time its tally changes.

  public static class _VisualCounter {

    private int N;
    private int max;
    private int cnt;
    private int opts;

    public _VisualCounter(int N, int max) {
      this.N = N;
      this.max = max;
      StdDraw.setXscale(0, N);
      StdDraw.setYscale(-max, max);
    }

    public void increment() {
      if (opts < N) {
        opts++;
      }
      if (cnt < max) {
        cnt++;
      }
      draw();
    }

    public void decrement() {
      if (opts < N) {
        opts++;
      }
      if (cnt > (-max)) {
        cnt--;
      }
      draw();
    }

    private void draw() {
      StdDraw.setPenRadius(0.01);
      StdDraw.setPenColor(Color.BLUE);
      StdDraw.point(opts, cnt);
    }

    public int tally() {
      return cnt;
    }

  }

  public static void main(String[] args) {
    _VisualCounter vs = new _VisualCounter(100, 50);
    for (int i = 0; i < 100; i++) {
      if (StdRandom.bernoulli(0.45) == true) {
        vs.increment();
      } else {
        vs.decrement();
      }
    }
  }
}
