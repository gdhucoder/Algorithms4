package ALeetCode.comp.p255;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int findGCD(int[] nums) {
      Arrays.sort(nums);
      int res = 1;
      int min = nums[0];
      int max = nums[nums.length - 1];
      for (int i = min; i >= 1; i--) {
        if (max % i == 0 && min % i == 0) return i;
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
