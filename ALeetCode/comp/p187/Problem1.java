package ALeetCode.comp.p187;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int kthSmallest(int[][] mat, int k) {
      boolean[] used = new boolean[mat.length];
      boolean[] used_column = new boolean[mat[0].length];
      helper(mat, used, used_column, new ArrayList<>());

      return 0;
    }

    private void helper(int[][] mat, boolean[] used, boolean[] used_column, List<Integer> path) {
      if (path.size() == mat[0].length) {
        System.out.println(path);
        return;
      }

      for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[0].length; j++) {
          path.add(mat[i][j]);
        }
      }


    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] a = {{1, 10, 10}, {1, 4, 5}, {2, 3, 6,}};
    System.out.println(s.kthSmallest(a, 2));
  }
}
