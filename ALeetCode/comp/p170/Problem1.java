package ALeetCode.comp.p170;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int maximum69Number(int num) {
      String n = "" + num;
      char[] nums = n.toCharArray();
      int max = num;
      for (int i = 0; i < nums.length; i++) {
        char temp = nums[i];
        int number = 0;
        if (nums[i] == '9') {
          nums[i] = '6';
        } else {
          nums[i] = '9';
        }

        number = Integer.parseInt(new String(nums));
        max = Math.max(max, number);
        nums[i] = temp;
      }
      return max;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.maximum69Number(9699));
  }
}
