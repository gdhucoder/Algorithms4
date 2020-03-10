//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//示例:
//输入: S = "a1b2"
//输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入: S = "3z4"
//输出: ["3z4", "3Z4"]
//
//输入: S = "12345"
//输出: ["12345"]
// 
//
// 注意： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _0784_LetterCasePermutation {

  public static void main(String[] args) {
    Solution solution = new _0784_LetterCasePermutation().new Solution();
    solution.letterCasePermutation("a1b1");

  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<String> letterCasePermutation(String s) {
      if (s.length() == 0) return new ArrayList<>();
      List<String> res = new ArrayList<>();
      helper(s.toCharArray(), 0, res);
      System.out.println(res);
      return res;
    }

    private void helper(char[] chs, int pos, List<String> res) {
      if (pos == chs.length) {
        res.add(new String(chs));
        return;
      }

      if (chs[pos] >= '0' && chs[pos] <= '9') {
        helper(chs, pos + 1, res);
      }
      else {
        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, pos + 1, res);
        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, pos + 1, res);
      }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}