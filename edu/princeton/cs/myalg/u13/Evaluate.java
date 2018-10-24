package edu.princeton.cs.myalg.u13;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import java.io.FileInputStream;

/**
 * Dijkstra's Two-Stack Algorithm for Expression Evaluation
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 * = 101
 * Created by HuGuodong on 2018/5/8.
 */

public class Evaluate {

  public static void main(String[] args) throws Exception {
    Stack<String> ops = new Stack<>();
    Stack<Double> vals = new Stack<>();
    FileInputStream fis = new FileInputStream("E:\\GDUT\\Dropbox\\Alg4\\test_data\\eval.txt");
    System.setIn(fis);
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("(")) {
        ;
      } else if (s.equals("+")
          || s.equals("-")
          || s.equals("*")
          || s.equals("/")) {
        ops.push(s);
      } else if (s.equals(")")) {
        // pop, evaluate, and push result if token is ")"
        String op = ops.pop();
        Double val = vals.pop();
        if (op.equals("+")) {
          val = vals.pop() + val;
        } else if (op.equals("-")) {
          val = vals.pop() - val;
        } else if (op.equals("*")) {
          val = vals.pop() * val;
        } else if (op.equals("/")) {
          val = vals.pop() / val;
        }
        vals.push(val);
      } else {
        vals.push(Double.parseDouble(s));
      }
    }
    System.out.println(vals.pop());
  }

}
