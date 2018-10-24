package edu.princeton.cs.myalg.u_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Stack;

/**
 * Created by HuGuodong on 2018/6/3.
 */

public class Ex_1_3_2 {

  public static void main(String[] args) {

    // 在java中 Stack last in first out LIFO
    Stack<String> stack = new Stack<>();
    while (!StdIn.isEmpty()){
      String item = StdIn.readString();
      if(!item.equals("-")){
        stack.push(item);
      }else if(!stack.empty()){
        StdOut.println(stack.pop() + " ");
      }
    }
  }

}
