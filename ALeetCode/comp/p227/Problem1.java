package ALeetCode.comp.p227;

import java.util.Arrays;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public boolean check(int[] nums) {

      int[] arr = Arrays.copyOf(nums, nums.length);
      Arrays.sort(arr);
      PrintUtil.show(arr);
      int startIdx = -1;
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] < nums[i - 1]) {
          startIdx = i;
          break;
        }
      }
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] != nums[(i + startIdx) % nums.length]) {

          return false;
        }
      }
      return true;
    }

  }

  public static void main(String[] args) {
    int[] nums = {6, 10, 6};
    Solution s = new Solution();
    System.out.println(s.check(nums));
  }
}
