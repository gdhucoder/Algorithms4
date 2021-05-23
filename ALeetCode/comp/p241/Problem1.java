package ALeetCode.comp.p241;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    List<List<Integer>> paths = new ArrayList<>();

    public int subsetXORSum(int[] nums) {
      int n = nums.length;
      boolean[] used = new boolean[n];
      helper(nums, used, 0, new ArrayList<Integer>());
      int sum = 0;
      for (List<Integer> list : paths) {
        sum += xor(list);
      }
      return sum;
    }

    private int xor(List<Integer> list) {
      int res = list.get(0);
      for (int i = 1; i < list.size(); i++) {
        res ^= list.get(i);
      }
      return res;
    }

    private void helper(int[] nums, boolean[] used, int idx, List<Integer> list) {
      for (int i = idx; i < nums.length; i++) {
        used[i] = true;
        list.add(nums[i]);
        paths.add(new ArrayList<>(list));
        helper(nums, used, i + 1, list);
        list.remove(list.size() - 1);
        used[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int res = s.subsetXORSum(new int[]{5, 1, 6});
    System.out.println(res);
  }
}
