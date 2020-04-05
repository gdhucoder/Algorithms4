//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 字符串


package leetcode.editor.cn;

public class _0917_ReverseOnlyLetters {

  public static void main(String[] args) {
    Solution solution = new _0917_ReverseOnlyLetters().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String reverseOnlyLetters(String s) {
      char[] chs = s.toCharArray();
      int start = 0, end = chs.length - 1;
      while (start < end) {
        if (!isValid(chs[start])) {
          start++;
          continue;
        }
        if (!isValid(chs[end])) {
          end--;
          continue;
        }
        char temp = chs[start];
        chs[start++] = chs[end];
        chs[end--] = temp;
      }
      return String.valueOf(chs);
    }

    private boolean isValid(char c) {
      return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}