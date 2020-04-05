package ALeetCode.comp.p183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public List<Integer> minSubsequence(int[] nums) {
      if (nums.length == 0) return Collections.emptyList();
      Arrays.sort(nums);
      List<Integer> res = new ArrayList<>();
      int sum_lead = 0, sum_tail = 0;
      int end = nums.length - 1;
      for (int n : nums) sum_lead += n;

      while (end >= 0) {
        sum_tail += nums[end];
        sum_lead -= nums[end];
        //        System.out.printf("%2d, %2d\n", sum_tail, sum_lead);
        res.add(nums[end]);
        end--;
        if (sum_tail > sum_lead) {
          break;
        }
      }
      //      System.out.println(res);
      return res;
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
    int[] a = {6};
    s.minSubsequence(a);
  }
}
