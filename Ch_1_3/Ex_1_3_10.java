package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/9.
 */

public class Ex_1_3_10 {
//  Write a filter InfixToPostfix that converts an arithmetic expression from in- fix to postfix

  public static void InfixToPostfix(String expr) {
    _Stack<String> operator = new _Stack<>();
    _Stack<String> operand = new _Stack<>();
    String[] exp = expr.split("\\s+");
    PrintUtil.show(exp);
    for (String e : exp) {
      if (e.equals("("))
        operator.push(e);
      else if (e.equals("+") || e.equals("-"))
        operator.push(e);
      else if (e.equals("*") || e.equals("/")) {
//        String s
        // TODO priority
      } else if (e.equals(")")) {
        String op = operator.pop();
        if (!op.equals("("))
          operand.push(op);
      } else
        operand.push(e);
    }

    operand.push(operator.pop());
    _Stack<String> rev = new _Stack<>();
    while (!operand.isEmpty()) {
      rev.push(operand.pop());
    }
    PrintUtil.show(rev);
  }

  public static void main(String[] args) {
    String expr = "( 1 + 2 ) * 3";
    InfixToPostfix(expr);
  }
}
