package ALeetCode.comp.p269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public List<Integer> targetIndices(int[] nums, int target) {
      var res = new ArrayList<Integer>();
      Arrays.sort(nums);
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
          res.add(i);
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
