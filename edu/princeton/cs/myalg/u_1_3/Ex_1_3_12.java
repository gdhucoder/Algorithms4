package edu.princeton.cs.myalg.u_1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/6/25.
 */

public class Ex_1_3_12 {

  /**
   * 1.3.12 Write an iterable Stack client that has a static method copy() that
   * takes a stack of strings as argument and returns a copy of the stack.
   * Note : This ability is a prime example of the value of having an iterator,
   * because it allows development of such functionality without changing the basic API.
   * @param args
   */
  public static void main(String[] args) {
    Stack<String> src = new Stack<>();
//    java.util.Stack
    src.push("1");
    src.push("2");
    src.push("3");
    StdOut.println(src);
    Stack cp = copy(src);

    StdOut.println(src == cp);
    StdOut.println(cp);

  }

  /**
   * 為了保證順序，我使用了兩個stack
   * @return
   */
  public static Stack<String> copy(Stack<String> src){
    Stack<String> cp = new Stack();
    Stack<String> reverse = new Stack();
    if(!src.isEmpty()){
      for(String s: src){
        cp.push(s);
      }
    }

    for(String s: cp){
      reverse.push(s);
    }

    return reverse;
  }

}
