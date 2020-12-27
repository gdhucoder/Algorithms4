package ALeetCode.comp.p221;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public int[] findBall(int[][] grid) {
      int m = grid.length; // 行数
      int n = grid[0].length; // 列数
      int[] ans = new int[n]; // 返回数组
      for (int c = 0; c < n; c++) {
        // 模拟每个小球
        ans[c] = dfs(grid, m, n, c, 0);
      }
      return ans;
    }

    private int dfs(int[][] grid, int m, int n, int c, int r) {
      // 卡在两边
      if (c == 0 && grid[r][c] == -1) return -1;
      if (c == n - 1 && grid[r][c] == 1) return -1;
      // 卡在中间
      if (grid[r][c] == 1 && grid[r][c + 1] == -1) return -1;
      if (grid[r][c] == -1 && grid[r][c - 1] == 1) return -1;
      // 到达底部，返回所在列的序号
      if (r == m) return c;
      // 递归
      return dfs(grid, m, n, c + grid[r][c], r + 1);
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
