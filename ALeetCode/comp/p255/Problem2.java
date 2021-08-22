package ALeetCode.comp.p255;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    private static final String PRE = "0000000000000000";

    public String findDifferentBinaryString(String[] nums) {
      int len = nums.length;
      Set<Integer> set = new HashSet<>();
      for (String num : nums) {
        set.add(Integer.valueOf(num, 2));
      }
      int targetNum = -1;
      for (int i = 0; i <= (int) Math.pow(2, len); i++) {
        if (!set.contains(i)) {
          targetNum = i;
          break;
        }
      }
      String ans = Integer.toBinaryString(targetNum);
      return PRE.substring(0, len - ans.length()) + ans;
    }


  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
