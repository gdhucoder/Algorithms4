package ALeetCode.comp.p235;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public static final int MOD = 1000000000 + 7;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
      if (arrEquals(nums1, nums2)) return 0;

      int n = nums1.length;
      int[] abs = new int[n];
      for (int i = 0; i < n; i++) {
        abs[i] = Math.abs(nums1[i] - nums2[i]);
      }
      int[] decre = new int[n];
      Arrays.fill(decre, Integer.MAX_VALUE);
      int decreMax = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        int num2 = nums2[i];
        for (int j = 0; j < n; j++) {
          if (i == j) continue;
          decre[i] = Math.min(Math.abs(nums1[j] - num2) - abs[i], decre[i]);
        }
        decreMax = Math.min(decre[i], decreMax);
      }
      int sum = 0;

      for (int i = 0; i < n; i++) {
        sum = (sum + abs[i]) % MOD;
      }
      sum += decreMax;
      return sum;
    }
  }

  private static boolean arrEquals(int[] num1, int[] num2) {
    for (int i = 0; i < num1.length; i++) {
      if (num1[i] != num2[i]) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
