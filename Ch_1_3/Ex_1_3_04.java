package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/4.
 */

public class Ex_1_3_04 {

  public static boolean isParenthesesBalanced(String exp) {
    _VarySizedCapacityStack<String> stack = new _VarySizedCapacityStack<>();
    for (int i = 0; i < exp.length(); i++) {
      String p = exp.substring(i, i + 1);
      stack.push(p);
      if ((p.equals(")") && stack.peek().equals("("))
          || p.equals("]") && stack.peek().equals("[")
          || p.equals("}") && stack.peek().equals("{")) {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }


  public static void main(String[] args) {
    String[] exps = {"[()]{}{[()()]()}", "[(])"};

    for (int i = 0; i < exps.length; i++) {
      String exp = exps[i];
      boolean balanced = isParenthesesBalanced(exp);
      if (!balanced) {
        StdOut.printf("%s is not balanced\n", exp);
      } else {
        StdOut.printf("%s is balanced\n", exp);
      }
//      [()]{}{[()()]()} is not balanced
//      [(]) is not balanced
    }


  }

}
