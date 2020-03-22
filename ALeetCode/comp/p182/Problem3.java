package ALeetCode.comp.p182;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean hasValidPath(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      boolean[][] visited = new boolean[m][n];
      init();
      visited[0][0] = true;
      return dfs(0, 0, m, n, grid, visited);
    }


    private void init() {
      map.put(1, Arrays.asList(1, 3, 5));
      map.put(2, Arrays.asList(2, 5, 6));
      map.put(3, Arrays.asList(2, 5, 6));
      map.put(4, Arrays.asList(2, 5, 6));
      map.put(5, Arrays.asList(2, 3, 4));
      map.put(6, Arrays.asList(1, 3, 5));
    }

    private boolean dfs(int row, int col, int m, int n, int[][] grid, boolean[][] visited) {
      System.out.println(row + ", " + col + "," + m + "," + n);

      if (row == m - 1 && col == n - 1) return true;
      if (row >= m || col >= n) return false;
      visited[row][col] = true;
      for (int i = row; i < m; i++) {
        for (int j = col; j < n; j++) {
          for (int k = 0; k < 4; k++) {
            // check around
            int newI = i + dir[k][0];
            int newJ = j + dir[k][1];
            if (check(i, j, newI, newJ, m, n, grid) && !visited[newI][newJ]) {
              return dfs(newI, newJ, m, n, grid, visited);
            }
          }
        }
      }
      visited[row][col] = false;
      return false;
    }

    private boolean check(int i, int j, int newI, int newJ, int m, int n, int[][] grid) {
      if (newI < 0 || newJ < 0 || newI >= m || newJ >= n) return false;
      List<Integer> nerb = map.get(grid[i][j]);
      if (nerb.contains(grid[newI][newJ])) return true;
      return false;
    }
  }


  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
    int[][] a = {{2, 4, 3}, {6, 5, 2}};
    System.out.println(s.hasValidPath(a));
  }
}
