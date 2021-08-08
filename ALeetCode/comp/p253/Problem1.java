package ALeetCode.comp.p253;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public boolean isPrefixString(String s, String[] words) {
      StringBuilder input = new StringBuilder();
      for (String w : words) {
        input.append(w);
        if (input.toString().equals(s)) {
          return true;
        }
      }
      return false;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
