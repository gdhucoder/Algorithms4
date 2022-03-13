package ALeetCode.comp.p284;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem4 {

  static class Solution {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
      List<Integer> keyIdxes = new ArrayList<Integer>();
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == key) {
          keyIdxes.add(i);
        }
      }

      List<Integer> res = new ArrayList<>();

      for (int i = 0, j = 0; i < nums.length && j < keyIdxes.size(); ) {
        int diff = i - keyIdxes.get(j);
        if (Math.abs(diff) <= k) {
          res.add(i);
          i++;
        }
        else if (diff < k) {
          i++;
        }
        else {
          j++;
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
