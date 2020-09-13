package ALeetCode.comp.p206;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int numSpecial(int[][] mat) {
      int res = 0;
      int m = mat.length;
      int n = mat[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (mat[i][j] == 1 && isValid(mat, i, j)) {
            res++;
          }
        }
      }
      return res;
    }

    private boolean isValid(int[][] mat, int a, int b) {
      boolean res = false;
      for (int i = 0; i < mat[a].length; i++) {
        if (i != b && mat[a][i] == mat[a][b]) {
          return false;
        }
      }
      for (int j = 0; j < mat.length; j++) {
        if (j != a && mat[j][b] == mat[a][b]) {
          return false;
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
