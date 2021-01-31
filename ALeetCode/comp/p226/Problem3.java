package ALeetCode.comp.p226;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
      int[] cnt = new int[candiesCount.length];
      boolean[] res = new boolean[queries.length];
      cnt[0] = candiesCount[0];
      for (int i = 1; i < candiesCount.length; i++) {
        cnt[i] += cnt[i - 1] + candiesCount[i];
      }
      for (int i = 0; i < queries.length; i++) {
        int[] q = queries[i];
        int type = q[0];
        int day = q[1] + 1;
        long cap = q[2];
        int min = day;
        long max = cap * day;
        res[i] = min >= cnt[type] && cnt[type] <= max;
      }
      return res;
    }
  }

  public static void main(String[] args) {
    System.out.println();
    int[] input = {7, 4, 5, 3, 8};
    int[][] queries = {{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}};
    Solution s = new Solution();
    s.canEat(input, queries);
  }
}
