package ALeetCode.comp.p256;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int minimumDifference(int[] nums, int k) {
      int len = nums.length;
      Arrays.sort(nums);
      int res = Integer.MAX_VALUE;
      for (int i = 0; i < len - k + 1; i++) {
        res = Math.min(res, nums[i + k - 1] - nums[i]);
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
