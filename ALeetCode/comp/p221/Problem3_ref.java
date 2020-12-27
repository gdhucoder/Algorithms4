package ALeetCode.comp.p221;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3_ref {

  static class Solution {

    public int[] findBall(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;

      int[] dp = new int[m];
      for (int i = 0; i < m; i++) dp[i] = i;

      for (int i = n - 1; i >= 0; i--) {
        int[] ndp = new int[m];
        Arrays.fill(ndp, -1);
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == -1) {
            if (j - 1 >= 0 && grid[i][j - 1] == -1) {
              ndp[j] = dp[j - 1];
            }
          }
          else {
            if (j + 1 < m && grid[i][j + 1] == 1) {
              ndp[j] = dp[j + 1];
            }
          }
        }
        dp = ndp;
      }
      return dp;
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
