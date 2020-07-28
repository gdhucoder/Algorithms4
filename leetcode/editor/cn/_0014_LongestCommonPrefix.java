//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1188 👎 0


package leetcode.editor.cn;

public class _0014_LongestCommonPrefix {

  public static void main(String[] args) {
    Solution solution = new _0014_LongestCommonPrefix().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String longestCommonPrefix(String[] s) {
      if (s.length == 0) return "";
      if (s.length == 1) return s[0];
      int minLen = minLen(s);
      String res = "";
      for (int i = 0; i < minLen; i++) {
        boolean flag = true;
        for (int j = 1; j < s.length; j++) {
          if (s[j - 1].charAt(i) != s[j].charAt(i)) {
            flag = false;
            break;
          }
        }
        if (flag) {
          res += ("" + s[0].charAt(i));
        }
        if (!flag) break;
      }
      return res;
    }

    private int minLen(String[] s) {
      int min = Integer.MAX_VALUE;
      for (String ss : s) {
        min = Math.min(min, ss.length());
      }
      return min;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}