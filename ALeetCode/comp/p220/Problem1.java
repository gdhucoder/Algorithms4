package ALeetCode.comp.p220;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public String reformatNumber(String number) {
      StringBuilder res = new StringBuilder();
      number = number.replaceAll("-", "").replaceAll(" ", "");
      int len = number.length();
      int pos = 0;
      while (pos < len) {
        if (len - pos > 4) {
          res.append(number, pos, pos + 3).append('-');
          pos += 3;
        }
        else {
          int tailLen = len - pos;
          if (tailLen < 4) {
            res.append(number, pos, len);
          }
          else {
            res.append(number, pos, pos + 2).append('-').append(number, pos + 2, len);
          }
          break;
        }
      }
      return res.toString();
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.reformatNumber("--17-5 229 35-39475 "));
    System.out.println(s.reformatNumber("123 4-5678"));
    System.out.println(s.reformatNumber("12"));
    System.out.println(s.reformatNumber("789-0469-2731  5107289"));
  }
}
