//实现函数 _0709_ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串


package leetcode.editor.cn;

public class _0709_ToLowerCase {

  public static void main(String[] args) {
    Solution solution = new _0709_ToLowerCase().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String toLowerCase(String s) {
      char[] chs = s.toCharArray();
      for (int i = 0; i < chs.length; i++) {
        if (chs[i] >= 'A' && chs[i] <= 'Z') chs[i] = (char) (chs[i] - 'A' + 'a');
      }
      return String.valueOf(chs);
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}