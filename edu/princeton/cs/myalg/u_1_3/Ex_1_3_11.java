package edu.princeton.cs.myalg.u_1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;

/**
 * Created by HuGuodong on 2018/6/25.
 */

public class Ex_1_3_11 {


  /**
   * Write a program EvaluatePostfix that takes a postfix expression from standard input, evaluates
   * it, and prints the value. (Piping the output of your program from the previous exercise to this
   * program gives equivalent behavior to Evaluate. 计算后缀表达式的值 eg: 1 2 3 + 4 5 * * +
   */
  public static void main(String[] args) throws Exception {
    FileInputStream fis = new FileInputStream
        ("E:\\GDUT\\Dropbox\\Alg4\\algs4\\src\\main\\java\\edu\\princeton\\cs\\myalg\\u_1_3\\input3_11.txt");
    System.setIn(fis);
//    Stack<String> ops = new Stack<>();
    Stack<Double> vals = new Stack<>();

    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("+")
          || s.equals("-")
          || s.equals("*")
          || s.equals("/")) {
        double v = vals.pop();

        if(s.equals("+")) v = v + vals.pop();
        if(s.equals("-")) v = v - vals.pop();
        if(s.equals("*")) v = v * vals.pop();
        if(s.equals("/")) v = v / vals.pop();

        vals.push(v);
      } else {
        vals.push(Double.parseDouble(s));
      }
    }
    StdOut.println(vals.pop());
  }

}
