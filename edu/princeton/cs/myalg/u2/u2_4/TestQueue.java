package edu.princeton.cs.myalg.u2.u2_4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by HuGuodong on 2018/10/17.
 */

public class TestQueue {

  public static void main(String[] args) {
    List<String> list = new LinkedList<>();
    Queue<String> q = new LinkedList<>();
    q.add("a");
    q.add("a");
    q.add("b");
    q.add("c");
    q.add("d");

    String temp = null;

    while (q.peek()!=null){
      temp = q.poll();
      System.out.println(temp);
    }
    System.out.println(temp);
  }


}
