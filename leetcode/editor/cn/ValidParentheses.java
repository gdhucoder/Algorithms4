//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

package leetcode.editor.cn;

public class ValidParentheses {

  public static void main(String[] args) {
    Solution solution = new ValidParentheses().new Solution();
    System.out.println(solution.isValid("(])"));
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public boolean isValid(String s) {
      char[] stack = s.toCharArray();
      int head = 0;
      for (char c : s.toCharArray()) {
        switch (c) {
          case '(':
            stack[head++] = ')';
            break;
          case '[':
            stack[head++] = ']';
            break;
          case '{':
            stack[head++] = '}';
            break;
          default:
            if (head == 0 || stack[--head] != c) {
              return false;
            }
            continue;
        }
      }
      return head == 0;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}