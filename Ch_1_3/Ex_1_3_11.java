package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/13.
 */

public class Ex_1_3_11 {

  public static double evlautePostFix(String exprs) {
    _Stack<Double> operand = new _Stack<>();
    String[] exps = exprs.split("\\s+");
    for (String e : exps) {
      if (e.matches("\\d")) {
        operand.push(Double.valueOf(e));
      } else {
        double op1 = operand.pop();
        double op2 = operand.pop();
        if (e.equals("+")) {
          operand.push(op1 + op2);
        }
        if (e.equals("-")) {
          operand.push(op1 - op2);
        }
        if (e.equals("*")) {
          operand.push(op1 * op2);
        }
        if (e.equals("/")) {
          operand.push(op1 / op2);
        }
      }
    }
    assert operand.size() == 1;
    return operand.pop();
  }

  public static void main(String[] args) {
    String expr = "5 3 4 * + 2 3 * - 3 / 1 3 + + ";
    double result = evlautePostFix(expr);
//    result = 3.73
    StdOut.printf("result = %.2f\n", result);
  }
}
