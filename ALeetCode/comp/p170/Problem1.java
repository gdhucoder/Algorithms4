package ALeetCode.comp.p170;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public String freqAlphabets(String s) {
      char[] chars = s.toCharArray();
      String res = "";
      int lo = 0;
      int hi = 0;
      while (lo < s.length() && hi < s.length()) {
        while (hi < s.length() && chars[hi] != '#') {
          hi++;
        }
//        System.out.println(hi);
        while (hi - lo > 2) {
          res += (char) ('a' + (chars[lo] - '0' - 1));
          lo++;
        }
        System.out.println(hi);
        System.out.println(lo);
        while (hi == s.length() && hi > lo) {
          res += (char) ('a' + (chars[lo] - '0' - 1));
          lo++;
        }
        if (hi < s.length() && hi - lo == 2) {
          int a = (chars[lo] - '0') * 10;
          lo++;
          int b = (chars[lo] - '0');
          res += (char) ('a' + a + b - 1);
          hi++;
          lo += 2;
        }

      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str = s.freqAlphabets("123");
//    assert str.equals("abcdefghijklmnopqrstuvwxyz");
//    abcdefghijklmnopqrstuvwxyz
//    abcdefghiklmnopqrstuvwxyz{
    System.out.println(str);
  }
}
