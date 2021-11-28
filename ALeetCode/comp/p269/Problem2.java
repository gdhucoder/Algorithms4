package ALeetCode.comp.p269;

import java.util.Arrays;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int[] getAverages(int[] nums, int k) {
      // i-3<0 res[i] = -1;
      // sum : 7 4 3
      // nums.length = 9 pos = k + 1
      int len = nums.length;
      int[] res = new int[len];
      Arrays.fill(res, -1);
      long sum = 0;
      int tk = k;
      for (int i = 0; i < len; i++) {
        sum += nums[i] - ((i > 2 * k) ? nums[i - 2 * k - 1] : 0);
        if (i >= 2 * k) {
          long temp = sum / (2 * k + 1);
          res[tk++] = (int) temp;
        }
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] in = new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6};
    int k = 3;
    var res = s.getAverages(in, k);
    PrintUtil.show(res);
    System.out.println();
  }
}
