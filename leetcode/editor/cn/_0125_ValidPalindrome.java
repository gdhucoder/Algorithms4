//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 264 👎 0


package leetcode.editor.cn;

public class _0125_ValidPalindrome {

  public static void main(String[] args) {
    Solution solution = new _0125_ValidPalindrome().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public boolean isPalindrome(String s) {
      char[] chs = s.toCharArray();
      int i = 0, j = chs.length - 1;
      while (i < j) {
        while (!valid(chs[i]) && i < j) i++;
        while (!valid(chs[j]) && i < j) j--;
        if (Character.toLowerCase(chs[i]) == Character.toLowerCase(chs[j])) {
          i++;
          j--;
        }
        else {
          return false;
        }
      }
      return true;
    }

    private boolean valid(char c) {
      if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
        return true;
      }
      return false;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}