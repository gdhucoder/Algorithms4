package ALeetCode.comp.p225;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public String maximumTime(String s) {
      String res = "";
      char pre;
      if (s.charAt(0) == '?') {
        res += "2";
      }
      else {
        res += s.charAt(0);
      }
      pre = res.charAt(0);

      if (s.charAt(1) == '?') {
        if (pre == '2') {
          res += "3";
        }
        else {
          res += "9";
        }
      }
      else {
        res += s.charAt(1);
      }
      pre = s.charAt(1);

      res += ":";

      if (s.charAt(3) == '?') {
        res += "5";
      }
      else {
        res += s.charAt(3);
      }

      if (s.charAt(4) == '?') {
        res += "9";
      }
      else {
        res += s.charAt(4);
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
