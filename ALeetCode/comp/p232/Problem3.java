package ALeetCode.comp.p232;

import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
      PriorityQueue<double[]> pq = new PriorityQueue<>((x, y) -> -Double.compare(x[0], y[0]));
      for (int[] c : classes) {
        pq.add(new double[]{(double) (c[0] + 1) / (c[1] + 1) - (double) c[0] / c[1], c[0], c[1]});
      }
      for (int z = 0; z < extraStudents; z++) {
        double[] cur = pq.poll();
        cur[1]++;
        cur[2]++;
        cur[0] = (double) (cur[1] + 1) / (cur[2] + 1) - (double) cur[1] / cur[2];
        pq.add(cur);
      }
      double ans = 0;
      for (double[] o : pq) {
        ans += o[1] / o[2];
      }
      return ans / classes.length;
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
