package ALeetCode.comp.p201;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public String makeGood(String s) {
      StringBuilder sb = new StringBuilder(s);
      return delete(sb).toString();
    }

    private StringBuilder delete(StringBuilder s) {
      boolean dele = false;
      for (int i = 0; i < s.length() - 1; i++) {
        if (s.charAt(i) + 32 == s.charAt(i + 1) || s.charAt(i + 1) + 32 == s.charAt(i)) {
          s.delete(i, i + 2);
          dele = true;
          break;
        }
      }
      if (!dele) {
        return s;
      }

      return delete(s);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.makeGood("mC"));
    System.out.println(0 + 'a');
    System.out.println(0 + 'A');
  }
}
