package ALeetCode.comp.p284;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
      boolean[][] grid = new boolean[n][n];
      for (int[] d : dig) {
        grid[d[0]][d[1]] = true;
      }
      int res = 0;
      for (int i = 0; i < artifacts.length; i++) {
        int[] ar = artifacts[i];
        if (isColored(grid, ar)) {
          res++;
        }
      }
      return res;
    }

    private static boolean isColored(boolean[][] grid, int[] a) {
      for (int i = a[0]; i <= a[2]; i++) {
        for (int j = a[1]; j <= a[3]; j++) {
          if (!grid[j][j]) {
            return false;
          }
        }
      }
      return true;
    }
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
