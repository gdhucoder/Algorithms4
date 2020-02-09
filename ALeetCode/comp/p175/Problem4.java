package ALeetCode.comp.p175;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem4 {

  static class Solution {

    public int maxStudents(char[][] map) {
      int n = map.length, m = map[0].length;
      int[] dp = new int[1 << m];
      Arrays.fill(dp, -9999999);
      dp[0] = 0;
      for (int i = n - 1; i >= 0; i--) {
        int[] ndp = new int[1 << m];
        inner:
        for (int j = 0; j < 1 << m; j++) {
          int b = j >>> 1 | j << 1;
          if ((b & j) != 0)
            continue;
          for (int k = 0; k < m; k++) {
            if (j << ~k < 0) {
              if (map[i][k] == '#')
                continue inner;
            }
          }
          int val = -9999999;
          for (int f = 0; f < 1 << m; f++) {
            int ng = f << 1 | f >>> 1;
            if ((ng & j) == 0) {
              val = Math.max(val, dp[f]);
            }
          }
          val += Integer.bitCount(j);
          ndp[j] = val;
        }
        dp = ndp;
      }
      int ans = 0;
      for (int v : dp)
        ans = Math.max(ans, v);
      return ans;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    char[][] map = {
        {'#', '.', '#', '#', '.', '#'},
        {'.', '#', '#', '#', '#', '.'},
        {'#', '.', '#', '#', '.', '#'}};

    int res = solution.maxStudents(map);
    System.out.println(res);
  }
}
