package ALeetCode.comp.p196;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public boolean canMakeArithmeticProgression(int[] a) {
      Arrays.sort(a);
      int former = a[1] - a[0];
      for (int i = 2; i < a.length; i++) {
        int cur = a[i] - a[i - 1];
        if (former != cur) return false;
        former = cur;
      }
      return true;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
