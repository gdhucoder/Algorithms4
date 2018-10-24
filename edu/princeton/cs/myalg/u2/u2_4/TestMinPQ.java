package edu.princeton.cs.myalg.u2.u2_4;

import edu.princeton.cs.algs4.MinPQ;

/**
 * Created by HuGuodong on 2018/10/23.
 */

public class TestMinPQ {

  public static void main(String[] args) {
    MinPQ<Integer> pq = new MinPQ<>();
    for(int i=0; i<10; i++){
      pq.insert(i);
    }

    System.out.println(pq.isMinHeap());
    System.out.println(MinPQ.count);
  }

}
