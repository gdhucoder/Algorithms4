package designpattern.u1;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by HuGuodong on 2019/11/9.
 */
public class Operation {

  public static double getResult(double a, double b, String op) {
    double result = 0;
    switch (op) {
      case "+":
        result = a + b;
        break;
      case "-":
        result = a - b;
        break;
      case "*":
        result = a * b;
        break;
      case "/":
        result = a / b;
        break;
    }
    return result;
  }

  public static void main(String[] args) {
    double r = getResult(10, 20, "-");
    System.out.println(r);
    double a = StdIn.readDouble();
    double b = StdIn.readDouble();
    String op = StdIn.readString();
    System.out.println("result is :" + getResult(a, b, op));
  }
}
