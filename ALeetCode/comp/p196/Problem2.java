package ALeetCode.comp.p196;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int getLastMoment(int n, int[] left, int[] right) {
      int len_L = left.length;
      int len_R = right.length;
      if (len_L > 0) Arrays.sort(left);
      if (len_R > 0) Arrays.sort(right);
      if (len_R == 0) return left[len_L - 1];
      if (len_L == 0) return n - right[0];
      double midTime = (0.0 + left[0] - right[len_R - 1]) / 2;
      return (int) (midTime + Math.max(right[len_R - 1] + midTime, n - left[0] + midTime));
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
