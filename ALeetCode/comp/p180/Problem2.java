package ALeetCode.comp.p180;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public String generateTheString(int n) {
      String res = "";
      if (n == 0) return res;
      int[] chs = new int[26];
      for (int i = 0; i < chs.length; i++) {
        chs[i] = i + 'a';
      }
      if (n >= 1 && n <= 26) {
        for (int i = 0; i < n; i++) {
          res += (char) chs[i];
        }
        return res;
      }
      else {
        if (n % 2 != 0) {
          for (int i = 0; i < n; i++) {
            res += (char) chs[0];
          }
          return res;
        }
        else {
          for (int i = 0; i < 25; i++) {
            res += (char) chs[i];
          }
          for (int i = 25; i < n; i++) {
            res += (char) chs[25];
          }
          return res;
        }
      }

    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.generateTheString(28));
    System.out.println(s.generateTheString(26));
    System.out.println(s.generateTheString(27));
  }
}
