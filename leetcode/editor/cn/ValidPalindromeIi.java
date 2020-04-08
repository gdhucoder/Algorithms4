//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串


package leetcode.editor.cn;

public class ValidPalindromeIi {

  public static void main(String[] args) {
    Solution solution = new ValidPalindromeIi().new Solution();
    String s = "aba";
    System.out.println(solution.validPalindrome(s));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public boolean validPalindrome(String s) {
      char[] chs = s.toCharArray();
      int start = 0, end = chs.length - 1;
      while (start < end && chs[start] == chs[end]) {
        start++;
        end--;
      }
      return isPalindrome(chs, start + 1, end) || isPalindrome(chs, start, end - 1);
    }

    private boolean isPalindrome(char[] chs, int start, int end) {
      while (start < end) {
        if (chs[start] != chs[end]) return false;
        start++;
        end--;
      }
      return true;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}