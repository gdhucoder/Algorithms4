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
import java.util.List;

public class _0022_GenerateParentheses_V1 {

  public static void main(String[] args) {
    Solution solution = new _0022_GenerateParentheses_V1().new Solution();
    System.out.println(solution.generateParenthesis(3));
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<String> generateParenthesis(int n) {
      List<String> res = new ArrayList<>();
      dfs("", res, n, n);
      return res;
    }

    public void dfs(String parenthesis, List<String> res, int left, int right) {
      if (left > right) {
        return;
      }
      if (left > 0) {
        dfs(parenthesis + "(", res, left - 1, right);
      }
      if (right > 0) {
        dfs(parenthesis + ")", res, left, right - 1);
      }
      if (left == 0 && right == 0) {
        res.add(parenthesis);
        return;
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}