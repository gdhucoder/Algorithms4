package ALeetCode;

/**
 * Created by HuGuodong on 2019/11/18.
 */
public class P0063_DP {

  static class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int[][] a = obstacleGrid;
      int n = a.length;
      int m = a[0].length;
      int[][] states = new int[n][m];
      for (int i = 0; i < n; i++) {
        states[i][0] = 1;
      }
      for (int i = 0; i < m; i++) {
        states[0][i] = 1;
      }
      for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
          if (a[i][j] == 1) {
            states[i][j] = 0;
          } else {
            states[i][j] = states[i - 1][j] + states[i][j - 1];
          }
        }
      }
      return states[n - 1][m - 1];
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] a = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    int ans = s.uniquePathsWithObstacles(a);
    System.out.println(ans);
  }
}
