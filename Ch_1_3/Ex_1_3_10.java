package Ch_1_3;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/9.
 */

public class Ex_1_3_10 {

  //  Write a filter InfixToPostfix that converts an arithmetic expression from infix to postfix
  public static void InfixToPostfix(String expr) {
    _Stack<String> operator = new _Stack<>();
    _Stack<String> operand = new _Stack<>();
    String[] exp = expr.split("\\s+");
    PrintUtil.show(exp);
    for (String e : exp) {
      switch (e) {
        case "+":
        case "-":
          getOperator(e, 0, operator, operand);
          break;
        case "*":
        case "/":
          getOperator(e, 1, operator, operand);
          break;
        case "(":
          operator.push(e);
          break;
        case ")":
          gotRightParent(operator, operand);
          break;
        default:
          operand.push(e);
          break;
      }
    }
    operand.push(operator.pop());
    PrintUtil.show(operand);
    _Stack<String> rev = new _Stack<>();
    while (!operand.isEmpty()) {
      rev.push(operand.pop());
    }
    PrintUtil.show(rev);
  }


  private static void getOperator(String op, int pri, _Stack<String> opr, _Stack<String> opn) {
    while (true) {
      if (opr.isEmpty() || opr.peek().equals("(")) {
        opr.push(op);
        break;
      } else if (pri > priority(opr.peek())) {
        opr.push(op);
        break;
      } else {
        opn.push(opr.pop());
      }
    }
  }

  private static void gotRightParent(_Stack<String> opr, _Stack<String> opn) {
    while (!opr.isEmpty()) {
      String op = opr.pop();
      if (op.equals("(")) {
        break;
      } else {
        opn.push(op);
      }
    }
  }

  private static int priority(String op) {
    if (op.equals("*") || op.equals("/")) {
      return 1;
    }
    return 0;
  }

  public static void main(String[] args) {
    String expr = "( 5 + 3 * 4 - 2 * 3 ) / 3 + ( 1 + 3 )";
    InfixToPostfix(expr);
//    5 	3 	4 	* 	+ 	2 	3 	* 	- 	3 	/ 	1 	3 	+ 	+
  }
}
