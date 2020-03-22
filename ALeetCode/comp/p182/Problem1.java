package ALeetCode.comp.p182;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int[] createTargetArray(int[] nums, int[] index) {
      if (nums.length == 0) return new int[]{};
      List<Integer> list = new ArrayList<>(nums.length);
      for (int i = 0; i < nums.length; i++) {
        list.add(index[i], nums[i]);
      }
      int[] res = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
        res[i] = list.get(i);
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
