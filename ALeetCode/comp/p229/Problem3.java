package ALeetCode.comp.p229;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    static List<Integer> list = new ArrayList<>();

    public int maximumScore(int[] nums, int[] mul) {
      boolean[] used = new boolean[nums.length];
      int res = fun(nums, mul, used, 0, nums.length - 1, 0, 0);
      return res;

    }

    private int fun(int[] nums, int[] mul, boolean[] used, int start, int end, int idx, int sum) {
      if (idx == mul.length - 1) {
        System.out.println(Math.max(nums[start] * mul[idx], nums[end] * mul[idx]));
        sum += Math.max(nums[start] * mul[idx], nums[end] * mul[idx]);
        //        System.out.println(sum);
        return sum;
      }
      idx += 1;
      return Math.max(fun(nums, mul, used, start + 1, end, idx + 1, sum += nums[start] * mul[idx]),
          fun(nums, mul, used, start, end - 1, idx + 1, sum += nums[end] * mul[idx]));
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
    int[] m = {-5, -3, -3, -2, 7, 1};
    int[] n = {-10, -5, 3, 4, 6};
    System.out.println(s.maximumScore(m, n));

  }
}
