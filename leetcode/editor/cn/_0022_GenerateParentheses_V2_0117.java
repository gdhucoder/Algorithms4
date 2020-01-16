//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0022_GenerateParentheses_V2_0117 {

  public static void main(String[] args) {
    Solution solution = new _0022_GenerateParentheses_V2_0117().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<String> generateParenthesis(int n) {
      if (n <= 0)
        return Collections.emptyList();
      List<String> res = new ArrayList<>();
      dfs("", n, n, res);
      return res;
    }

    private void dfs(String cur, int left, int right, List<String> res) {
      if (left == 0 && right == 0) {
        res.add(cur);
        return;
      }
      if (left > right)
        return;
      if (left > 0)
        dfs(cur + "(", left - 1, right, res);
      if (right > 0)
        dfs(cur + ")", left, right - 1, res);
    }


  }
//leetcode submit region end(Prohibit modification and deletion)

}