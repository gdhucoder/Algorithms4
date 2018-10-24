package edu.princeton.cs.myalg.u_1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/6/11.
 */

public class Ex_1_3_6 {


  /**
   * reverse a queue
   * @param args
   */
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    Queue<String> q = new Queue<>();
    q.enqueue("1");
    q.enqueue("2");
    q.enqueue("3");
    while(!q.isEmpty()){
      stack.push(q.dequeue());
    }

    while (!stack.isEmpty()){
      q.enqueue(stack.pop());
    }

    StdOut.println(q);
    // 321
  }

}
