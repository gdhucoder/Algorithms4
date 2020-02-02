package ALeetCode.comp.p171;

import java.util.Arrays;

/**
 * 这是一个参考答案，接下来要学习一下图的相关算法
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      int[][] d = new int[n][n];
      for (int i = 0; i < n; i++) {
        Arrays.fill(d[i], 99999999);
        d[i][i] = 0;
      }
      for (int[] e : edges) {
        d[e[0]][e[1]] = d[e[1]][e[0]] = Math.min(d[e[0]][e[1]], e[2]);
      }
      for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            if (d[i][j] > d[i][k] + d[k][j]) {
              d[i][j] = d[i][k] + d[k][j];
            }
          }
        }
      }

      int min = 9999999;
      int arg = -1;
      for (int i = 0; i < n; i++) {
        int num = 0;
        for (int j = 0; j < n; j++) {
          if (d[i][j] <= distanceThreshold) {
            num++;
          }
        }
        if (num <= min) {
          min = num;
          arg = i;
        }
      }
      return arg;
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
