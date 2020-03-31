//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串


package leetcode.editor.cn;

public class _0058_LengthOfLastWord {

  public static void main(String[] args) {
    Solution solution = new _0058_LengthOfLastWord().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int lengthOfLastWord1(String s) {
      if (s.length() == 0) return 0;
      String[] a = s.split(" ");
      int len = a.length;
      return len > 0 ? a[len - 1].length() : 0;
    }

    public int lengthOfLastWord2(String s) {
      if (s.length() == 0) return 0;
      int len = 0, tail = s.length() - 1;
      while (tail > 0 && s.charAt(tail) == ' ') tail--;
      while (tail > 0 && s.charAt(tail) != ' ') {
        len++;
        tail--;
      }
      return len;
    }

  }
  //leetcode submit region end(Prohibit modification and deletion)

}