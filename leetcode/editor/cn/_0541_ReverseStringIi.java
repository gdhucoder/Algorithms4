//给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于
// 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。 
//
// 示例: 
//
// 
//输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 要求: 
//
// 
// 该字符串只包含小写的英文字母。 
// 给定字符串的长度和 k 在[1, 10000]范围内。 
// 
// Related Topics 字符串


package leetcode.editor.cn;

public class _0541_ReverseStringIi {

  public static void main(String[] args) {
    Solution solution = new _0541_ReverseStringIi().new Solution();
    String s = "abcdefg";
    int k = 2;
    solution.reverseStr(s, k);

  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String reverseStr(String s, int k) {
      char[] chs = s.toCharArray();
      for (int i = 0, len = chs.length; i < len; i += 2 * k) {
        reserse(chs, i, Math.min(i + k - 1, len - 1));
      }
      return String.valueOf(chs);
    }

    private void reserse(char[] chs, int start, int end) {
      while (start < end) {
        char temp = chs[start];
        chs[start++] = chs[end];
        chs[end--] = temp;
      }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}