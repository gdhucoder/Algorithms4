//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;

public class _0005_LongestPalindromicSubstring_v2 {

  public static void main(String[] args) {
    Solution solution = new _0005_LongestPalindromicSubstring_v2().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String longestPalindrome(String s) {
      int len = s.length();
      if (len < 2) return s;
      boolean[][] dp = new boolean[len][len];
      for (int i = 0; i < len; i++) dp[i][i] = true;
      int start = 0, end = 0;
      char[] chs = s.toCharArray();
      for (int r = 1; r < len; r++) {
        for (int l = 0; l < r; l++) {
          if (chs[l] == chs[r] && (r - l < 2 || dp[l + 1][r - 1])) {
            dp[l][r] = true;
            if (r - l > end - start) {
              start = l;
              end = r;
            }
          }
          else {
            dp[l][r] = false;
          }
        }
      }
      return s.substring(start, end + 1);
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}