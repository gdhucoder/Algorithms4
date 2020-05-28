//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 示例: 
//
// 
//s = "3[a]2[bc]", 返回 "aaabcbc".
//s = "3[a2[c]]", 返回 "accaccacc".
//s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
// 
// Related Topics 栈 深度优先搜索


package leetcode.editor.cn;

import java.util.Stack;

public class _0394_DecodeString {

  public static void main(String[] args) {
    Solution solution = new _0394_DecodeString().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String decodeString(String s) {
      Stack<Integer> cntStack = new Stack<>();
      Stack<StringBuilder> strStack = new Stack<>();
      StringBuilder cur = new StringBuilder();
      int k = 0;
      for (char ch : s.toCharArray()) {
        if (Character.isDigit(ch)) {
          k = k * 10 + ch - '0';
        }
        else if (ch == '[') {
          cntStack.push(k);
          k = 0;
          strStack.push(cur);
          cur = new StringBuilder();
        }
        else if (ch == ']') {
          StringBuilder tmp = cur;
          cur = strStack.pop();
          for (k = cntStack.pop(); k > 0; --k) cur.append(tmp);
        }
        else cur.append(ch);
      }
      return cur.toString();
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}