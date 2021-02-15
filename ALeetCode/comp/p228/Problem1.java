package ALeetCode.comp.p228;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int minOperations(String s) {
      char[] chs = s.toCharArray();
      int sumLeadingZero = 0, sumLeadingOne = 0;
      int startWithZero = 0, startWithOne = 1;
      for (char c : chs) {
        if (c - '0' != startWithZero % 2) {
          sumLeadingZero++;
        }
        if (c - '0' != startWithOne % 2) {
          sumLeadingOne++;
        }
        startWithZero++;
        startWithOne++;
      }
      return Math.min(sumLeadingOne, sumLeadingZero);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
