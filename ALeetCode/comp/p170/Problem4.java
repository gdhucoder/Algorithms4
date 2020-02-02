package ALeetCode.comp.p170;

import java.util.Arrays;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem4 {

  static class Solution {

    public int minTaps(int n, int[] ranges) {
      int[][] rgs = new int[ranges.length][2];
      for (int i = 0; i < ranges.length; i++) {
        rgs[i][0] = i - ranges[i];
        rgs[i][1] = i + ranges[i];
      }

      Arrays.sort(rgs, (x, y) -> {
        return Math.max(0, x[0]) > Math.max(0, y[0]) ? 1 :
            x[0] == y[0] ? y[1] - x[1] : -1;
      });

      PrintUtil.show(rgs);
      int cnt = 0;
      int last_start = 0;
      int end = 0;
      for (int[] r : rgs) {
        if (r[1] <= end || r[0] == r[1])
          continue;
        end = r[1];

        cnt++;
        if (end >= n)
          break;
      }
      return cnt == 0 ? -1 : cnt;
    }
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    int[] ranges = {
        0, 5, 0, 3, 3, 3, 1, 4, 0, 4};

    System.out.println(s.minTaps(9, ranges));
  }
}
