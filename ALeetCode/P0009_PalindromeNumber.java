package ALeetCode;

/**
 * Created by HuGuodong on 11/26/19.
 */
public class P0009_PalindromeNumber {

  static class Solution {

    public boolean isPalindrome(int x) {
      String s = String.valueOf(x);
      char[] chars = s.toCharArray();
      for (int i = 0; i < chars.length / 2; i++) {
        if (chars[i] != chars[chars.length - 1 - i]) {
          return false;
        }
      }
      return true;
    }
  }
}
