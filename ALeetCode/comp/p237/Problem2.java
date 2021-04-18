package ALeetCode.comp.p237;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int maxIceCream(int[] costs, int coins) {
      Arrays.sort(costs);
      int max = 0, i = 0, sum = 0;
      for (; i < costs.length; i++) {
        sum += costs[i];
        if (sum > coins) break;
      }
      return i;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
