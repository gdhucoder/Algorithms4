//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例 1: 
//
// 
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
// 
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// Related Topics 字符串


package leetcode.editor.cn;

public class _0557_ReverseWordsInAStringIii {

  public static void main(String[] args) {
    Solution solution = new _0557_ReverseWordsInAStringIii().new Solution();
    String s = "hello world";
    System.out.println(solution.reverseWords(s));

  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String reverseWords(String s) {
      s += " ";
      char[] chs = s.toCharArray();
      for (int i = 0, start = 0; i < chs.length; i++) {
        if (chs[i] == ' ') {
          swap(chs, start, i - 1);
          start = i + 1;
        }
      }
      return String.valueOf(chs).trim();
    }

    private void swap(char[] chs, int start, int end) {
      while (start < end) {
        char temp = chs[start];
        chs[start++] = chs[end];
        chs[end--] = temp;
      }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}