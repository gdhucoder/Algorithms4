package ALeetCode.comp.p200;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public int minSwaps(int[][] grid) {
      if (!valid(grid)) return -1;
      int res = 0;
      for (int i = 0; i < grid.length; i++) {
        if (grid[i][i] != 1) {
          for (int j = i + 1; j < grid.length; j++) {
            if (grid[j][i] == 1) {
              //swap between (grid, i,j)
              res += j - i;
            }
          }
        }

      }
      return res;
    }

    private boolean valid(int[][] a) {
      for (int j = 0; j < a[0].length; j++) {
        int cntOnes = 0;
        for (int i = 0; i < a.length; i++) {
          cntOnes += a[i][j];
        }
        if (cntOnes == 0) return false;
      }
      return true;
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
