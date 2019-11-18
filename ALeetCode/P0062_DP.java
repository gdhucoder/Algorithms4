package ALeetCode;

/**
 * Created by HuGuodong on 2019/11/18.
 */
public class P0062_DP {

  /**
   * Dynamic Programming
   */
  static class Solution {

    public int uniquePaths(int m, int n) {
      int[][] states = new int[n][m];
      for (int i = 0; i < n; i++) {
        states[i][0] = 1;
      }
      for (int i = 0; i < m; i++) {
        states[0][i] = 1;
      }
      for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
          states[i][j] = states[i - 1][j] + states[i][j - 1];
        }
      }
      return states[n - 1][m - 1];
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ans = s.uniquePaths(7, 3);
    System.out.printf("%2d \n", ans);
  }
}
