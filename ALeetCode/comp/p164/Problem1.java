package ALeetCode.comp.p164;

/**
 * Created by HuGuodong on 11/24/19.
 */
public class Problem1 {

  static class Solution {

    public int minTimeToVisitAllPoints(int[][] points) {
      int[][] a = points;
      int sum = 0;
      for (int i = 1; i < a.length; i++) {
        sum += Math.max(Math.abs(a[i - 1][0] - a[i][0]), Math.abs(a[i - 1][1] - a[i][1]));
      }
      return sum;
    }
  }
}
