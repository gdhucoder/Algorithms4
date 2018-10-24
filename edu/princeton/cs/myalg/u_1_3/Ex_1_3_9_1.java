package edu.princeton.cs.myalg.u_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;
import java.util.Stack;

/**
 * Created by HuGuodong on 2018/6/25.
 */

public class Ex_1_3_9_1 {

  public static void main(String[] args)  throws Exception{
    FileInputStream fis = new FileInputStream("E:\\GDUT\\Dropbox\\Alg4\\algs4\\src\\main\\java\\edu\\princeton\\cs\\myalg\\u_1_3\\input3_9.txt");
    System.setIn(fis);
    Stack<String> ops  = new Stack<String>();
    Stack<String> vals = new Stack<String>();

    while (!StdIn.isEmpty())
    {
      String s = StdIn.readString();

      if      (s.equals("("))               ;
      else if (s.equals("+") ||
          s.equals("-") ||
          s.equals("*") ||
          s.equals("/") ||
          s.equals("sqrt")) ops.push(s);
      else if (s.equals(")"))
      {
        String op = ops.pop();
        String v = vals.pop();

        if (op.equals("+") ||
            op.equals("-") ||
            op.equals("*") ||
            op.equals("/"))
          v = String.format("( %s %s %s )", vals.pop(), op, v);
        else if (op.equals("sqrt"))
          v = String.format("( %s %s )", op, v);

        vals.push(v);
      }
      else vals.push(s);
      //else vals.push(((Double)Double.parseDouble(s)).toString());
    }

    StdOut.println(vals.pop());
  }

}
