package edu.princeton.cs.myalg.u_1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;

/**
 * Created by HuGuodong on 2018/6/11.
 */


public class Ex_1_3_9 {

//Write a program that takes from standard input an expression without left parentheses and prints the equivalent infix expression with the parentheses inserted. For example, given the input:
// 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
// ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
// stack: last in first out(LIFO)

  public static void main(String[] args) throws Exception{
    FileInputStream fis = new FileInputStream("E:\\GDUT\\Dropbox\\Alg4\\algs4\\src\\main\\java\\edu\\princeton\\cs\\myalg\\u_1_3\\input3_9.txt");
    System.setIn(fis);
    Stack<String> ops = new Stack<>();
    Stack<String> vals = new Stack<>();
    while (!StdIn.isEmpty()){
      String s = StdIn.readString();
      if(s.equals("+")
          || s.equals("-")
          || s.equals("*")
          || s.equals("/")){
        ops.push(s);
      }else if(s.equals(")")){
        String op = ops.pop();
        String v = vals.pop();

        v = String.format("( %s %s %s )", vals.pop(), op, v);
        vals.push(v);
      }else {
        vals.push(s);
      }
    }
    StdOut.println(vals.pop());
  }

}
