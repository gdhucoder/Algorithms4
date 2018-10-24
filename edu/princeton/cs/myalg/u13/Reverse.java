package edu.princeton.cs.myalg.u13;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;

/**
 * Created by HuGuodong on 2018/5/8.
 */

public class Reverse {

  public static void main(String[] args) throws Exception {
    // input order: 100 99 101 120 98 107 109 81 101 90
    FileInputStream fis = new FileInputStream("E:\\GDUT\\Dropbox\\Alg4\\test_data\\stats.txt");
    System.setIn(fis);
    Stack<Integer> stack;
    stack = new Stack<>();
    while (!StdIn.isEmpty()) {
      stack.push(StdIn.readInt());
    }

    for (int i : stack) {
      StdOut.println(i);
    }
  }

}
