package ALeetCode.comp.p200;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int countGoodTriplets(int[] nums, int a, int b, int c) {
      int res = 0;
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          for (int k = j + 1; k < nums.length; k++) {
            if (Math.abs(nums[i] - nums[j]) <= a && Math.abs(nums[j] - nums[k]) <= b
                && Math.abs(nums[i] - nums[k]) <= c) {
              res++;
            }
          }
        }
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
