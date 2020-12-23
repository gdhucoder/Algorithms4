package ALeetCode.comp.p220;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    final int LEN = 10;

    public int maximumUniqueSubarray(int[] nums) {
      int l = 0;
      int ret = 0, tot = 0;
      int[] bz = new int[LEN];
      for (int i = 0; i < nums.length; i++) {
        while (bz[nums[i]] > 0) {
          PrintUtil.show(bz);
          bz[nums[l]]--;
          tot -= nums[l];
          l++;

        }
        tot += nums[i];
        ret = Math.max(ret, tot);
        bz[nums[i]]++;
      }
      return ret;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
    System.out.println(s.maximumUniqueSubarray(new int[]{5, 2, 1, 1, 2, 5, 3, 1}));
    System.out.println(s.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
    System.out.println(s.maximumUniqueSubarray(new int[]{5, 2, 1, 3, 2, 5, 6, 7, 2, 1, 2, 5}));
    //    0 1 1 0 0 1 0 0 0 0
    //    0 1 1 0 0 0 0 0 0 0
    //    0 1 0 0 0 0 0 0 0 0
    //    0 1 1 1 0 1 0 0 0 0
    //    11
    //    0 0 1 0 1 0 0 0 0 0
    //    17
    //    0 1 1 1 0 1 0 0 0 0
    //    0 1 1 1 0 0 0 0 0 0
    //    0 1 1 1 0 1 1 1 0 0
    //    0 0 1 1 0 1 1 1 0 0
    //    0 0 1 0 0 1 1 1 0 0
    //    0 1 1 0 0 1 1 1 0 0
    //    0 1 1 0 0 0 1 1 0 0
    //    0 1 1 0 0 0 0 1 0 0
    //    0 1 1 0 0 0 0 0 0 0
    //    24
  }
}
