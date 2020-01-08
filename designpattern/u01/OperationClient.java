package designpattern.u01;

/**
 * Created by HuGuodong on 2019/11/9.
 */
public class OperationClient {

  public static void main(String[] args) {
    double a = 10;
    double b = 20;
    AbstractOperation operation = OperationFactory.createOp("+");
    operation.setA(a);
    operation.setB(b);
    double result = operation.getResult();
    System.out.println(result);
  }
}
