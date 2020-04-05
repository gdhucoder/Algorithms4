package ALeetCode.comp.p183;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem4 {

  static class Solution {

    public String stoneGameIII(int[] s) {
      return null;
    }

    private void helper(int[] s, int a, int b, int sum_a, int sum_b) {

      helper(s, a, b, sum_a + s[a], sum_b);
    }
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    System.out.println();
  }
}
