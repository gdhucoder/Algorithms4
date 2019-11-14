package ALeetCode;

/**
 * Created by HuGuodong on 2019/11/14.
 */
public class P0053 {

  static class Solution {

    public int maxSubArray(int[] nums) {
      int[] a = nums;
      int sum = 0;
      int i = 0;
      int max = Integer.MIN_VALUE;
      while (i < nums.length) {
        if (sum < 0) {
          sum = a[i];
        } else {
          sum += a[i];
        }
        if (sum > max) {
          max = sum;
        }
        i++;

      }
      return max;
    }
  }


}
