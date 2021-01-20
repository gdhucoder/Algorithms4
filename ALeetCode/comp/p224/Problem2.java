package ALeetCode.comp.p224;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int tupleSameProduct(int[] nums) {
      Arrays.sort(nums);
      int res = 0;
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length - 1; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          int num = nums[i] * nums[j];
          map.put(num, map.getOrDefault(num, 0) + 1);
        }
      }
      for (Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() > 1) {
          res += (entry.getValue() - 1) * 8;
        }
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] input = {2, 3, 4, 6, 8, 12};
    System.out.println(s.tupleSameProduct(input));
  }
}
