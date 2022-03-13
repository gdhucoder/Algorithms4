package ALeetCode.comp.p283;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public long minimalKSum(int[] nums, int k) {
      Arrays.sort(nums);
      long res = (long) (k + 1) * k / 2;
      int level = k + 1;
      for (int i = 0; i < nums.length; i++) {
        int cur = nums[i];
        if (i > 0 && cur == nums[i - 1]) {
          continue;
        }
        if (cur < level) {
          res += level - cur;
          level += 1;
        }
      }
      return res;
    }
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    int res = 0;
    for (int i = 1; i <= 100; i++) {
      res += i;
    }
    System.out.println(res);
    System.out.println(100 * 101 / 2);
    int[] input = {5, 6};
    System.out.println(s.minimalKSum(input, 6));
  }
}