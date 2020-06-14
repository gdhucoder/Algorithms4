package ALeetCode.comp.p193;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int[] runningSum(int[] nums) {
      int[] res = new int[nums.length];
      int temp = 0;
      for (int i = 0; i < nums.length; i++) {
        temp += nums[i];
        res[i] = temp;
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
