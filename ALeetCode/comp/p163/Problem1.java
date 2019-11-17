package ALeetCode.comp.p163;

import java.util.ArrayList;
import java.util.List;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/11/17.
 */
public class Problem1 {

  static class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

      int n = grid.length;
      int m = grid[0].length;
      int[][] temp = new int[n][m];

      for (int cnt = 0; cnt < k; cnt++) {

        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            temp[i][j] = grid[i][j];
          }
        }

        // copy temp
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m - 1; j++) {
            grid[i][j + 1] = temp[i][j];
          }
        }
        for (int i = 0; i < n - 1; i++) {
          grid[i + 1][0] = temp[i][m - 1];
        }
        grid[0][0] = temp[n - 1][m - 1];
      }
      PrintUtil.show(grid);
      List<List<Integer>> ans = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        List<Integer> l = new ArrayList<>(m);
        for (int j = 0; j < m; j++) {
          l.add(grid[i][j]);
        }
        ans.add(l);
      }

      return ans;
    }
  }

  public static void main(String[] args) {
    int[][] g = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    Solution p = new Solution();
    p.shiftGrid(g, 1);
  }
}
