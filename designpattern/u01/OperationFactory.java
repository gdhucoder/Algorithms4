package designpattern.u01;

/**
 * Created by HuGuodong on 2019/11/9.
 */
public class OperationFactory {

  public static AbstractOperation createOp(String op) {
    AbstractOperation oper = null;
    switch (op) {
      case "+":
        oper = new OperationAdd();
        break;
      case "-":
        oper = new OperationSub();
        break;
      case "*":
        oper = new OperationMult();
        break;
      case "/":
        oper = new OperationDiv();
        break;

    }
    return oper;
  }
}
