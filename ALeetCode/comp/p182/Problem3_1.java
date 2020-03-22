package ALeetCode.comp.p182;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3_1 {

  static class Solution {

    public boolean hasValidPath(int[][] a) {
      int n = a.length, m = a[0].length;

      int[][][] ds = {{{0, -1}, {0, 1}}, {{-1, 0}, {1, 0}}, {{0, -1}, {1, 0}}, {{0, 1}, {1, 0}},
          {{0, -1}, {-1, 0}}, {{0, 1}, {-1, 0}}};

      boolean[][] ved = new boolean[n][m];
      Queue<int[]> q = new ArrayDeque<>();
      q.add(new int[]{0, 0});
      ved[0][0] = true;
      while (!q.isEmpty()) {
        int[] cur = q.poll();
        int r = cur[0], c = cur[1];
        int num = a[r][c] - 1;
        for (int[] d : ds[num]) {
          int nr = r + d[0], nc = c + d[1];
          if (nr >= 0 && nr < n && nc >= 0 && nc < m && !ved[nr][nc]) {
            boolean rok = false;
            for (int[] ld : ds[a[nr][nc] - 1]) {
              if (nr + ld[0] == r && nc + ld[1] == c) {
                rok = true;
              }
            }
            if (rok) {
              ved[nr][nc] = true;
              q.add(new int[]{nr, nc});
            }
          }
        }
      }
      return ved[n - 1][m - 1];
    }

  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
