package ALeetCode.comp.p232;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3_1 {

  static class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
      double total = 0.0;
      var queue = new PriorityQueue<>(
          Comparator.comparingDouble(Pair<Double, int[]>::getP1).reversed());

      for (int[] c : classes) {
        total += (double) c[0] / c[1];
        queue.offer(new Pair(profit(c[0], c[1]), new int[]{c[0], c[1]}));
      }

      for (int i = 0; i < extraStudents; i++) {
        var pair = queue.poll();
        var addedProfit = pair.p1;
        total += addedProfit;
        var c = pair.p2;
        c[0]++;
        c[1]++;
        queue.offer(new Pair(profit(c[0], c[1]), new int[]{c[0], c[1]}));
      }
      return total / classes.length;
    }

    private static double profit(double pass, double total) {
      return (pass + 1) / (total + 1) - pass / total;
    }

    public static class Pair<T, U> {

      public Pair() {

      }

      public Pair(T t, U u) {
        p1 = t;
        p2 = u;
      }

      T p1;
      U p2;

      public T getP1() {
        return p1;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println();
    int[][] in = {{1, 2}, {3, 5}, {2, 2}};
    int e = 2;
    Solution s = new Solution();
    System.out.println(s.maxAverageRatio(in, e));
  }
}
