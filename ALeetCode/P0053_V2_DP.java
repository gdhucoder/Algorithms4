package ALeetCode;

/**
 * Created by HuGuodong on 2019/11/14.
 */
public class P0053_V2_DP {

  /**
   * DP Space O(N) https://leetcode-cn.com/problems/maximum-subarray/submissions/
   */
  static class Solution {

    public int maxSubArray(int[] nums) {
      if (nums.length == 1) {
        return nums[0];
      }
      int[] a = nums;
      int[] states = new int[a.length];
      states[0] = a[0];
      int max = Integer.MIN_VALUE;
      for (int i = 1; i < a.length; i++) {
        if (states[i - 1] < 0) {
          states[i] = a[i];
        } else {
          states[i] = states[i - 1] + a[i];
        }
      }
      for (int i = 0; i < a.length; i++) {
        if (states[i] > max) {
          max = states[i];
        }
      }
      return max;
    }
  }
}
