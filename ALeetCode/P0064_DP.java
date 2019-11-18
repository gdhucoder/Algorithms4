package ALeetCode;

/**
 * Created by HuGuodong on 2019/11/18.
 */
public class P0064_DP {

  static class Solution {

    public int minPathSum(int[][] grid) {
      int[][] a = grid;
      int m = grid.length;
      int n = grid[0].length;
      int[][] states = new int[m][n];
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += grid[0][i];
        states[0][i] = sum;
      }
      sum = 0;
      for (int i = 0; i < m; i++) {
        sum += grid[i][0];
        states[i][0] = sum;
      }

      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          states[i][j] = grid[i][j] + Math.min(states[i][j - 1], states[i - 1][j]);
        }
      }
      return states[m - 1][n - 1];
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] grid = {{1, 3, 1}, {1, 3, 1}, {4, 2, 1}};
    int ans = s.minPathSum(grid);
    System.out.println(ans);
  }
}
