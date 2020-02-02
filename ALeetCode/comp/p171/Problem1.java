package ALeetCode.comp.p171;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int removePalindromeSub(String s) {
      if (s.length() == 0)
        return 0;
      int l = s.length();
      char[] chars = s.toCharArray();
      for (int i = 0; i < (l >> 1); i++) {
        if (chars[i] != chars[l - i - 1])
          return 2;
      }
      return 1;
    }
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.removePalindromeSub("abb"));
    System.out.println(s.removePalindromeSub("baabb"));
    System.out.println(s.removePalindromeSub("ababa"));
    System.out.println(s.removePalindromeSub(""));
    System.out.println(s.removePalindromeSub("bbaabaaa"));
  }
}
