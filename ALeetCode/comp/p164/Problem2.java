package ALeetCode.comp.p164;

/**
 * Created by HuGuodong on 11/24/19.
 */
public class Problem2 {

  static class Solution {

    public int countServers(int[][] grid) {
      int[][] a = grid;
      int m = a.length;
      int n = a[0].length;
      int sum = 0;

      int[][] count_time = new int[m][n];

      for (int i = 0; i < m; i++) {
        int row_sum = 0;
        for (int j = 0; j < n; j++) {

          if (a[i][j] == 1) {
            row_sum += a[i][j];
            count_time[i][j]++;
          }
        }
        if (row_sum >= 2) {
          sum += row_sum;
        } else {
          for (int j = 0; j < n; j++) {
            count_time[i][j] = 0;
          }
        }
      }

      for (int col = 0; col < n; col++) {
        int col_sum = 0;
        for (int row = 0; row < m; row++) {
          if (a[row][col] == 1) {
            col_sum += a[row][col];
            count_time[row][col] += 1;
          }
        }
        if (col_sum >= 2) {
          sum += col_sum;
        } else {
          for (int r = 0; r < m; r++) {
            count_time[r][col] = 0;
          }
        }
      }
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (count_time[i][j] > 1) {
            sum -= (count_time[i][j] - 1);
          }
        }
      }

      return sum;
    }
  }
}
