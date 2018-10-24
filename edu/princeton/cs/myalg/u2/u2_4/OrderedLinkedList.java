package edu.princeton.cs.myalg.u2.u2_4;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/10/17.
 */

public class OrderedLinkedList<Key extends Comparable<Key>> {
  private Node first;
  private int N;

  public boolean isEmpty(){
    return N == 0; // or N == 0
  }

  private int size(){
    return N;
  }

  /**
   * 遍历链表找到插入的位置
   * @param v
   */
  public void insert(Key v){
    if(isEmpty()){
      first.item = v;
    }


    N++;

  }

  public Key delMax(){
    Key item = first.item;
    first = first.next;
    N--;
    return item;
  }

  private boolean less(Key a, Key b){
    return a.compareTo(b)<0;
  }


  private class Node{
    Key item;
    Node next;
  }

  public static void main(String[] args) {
    OrderedLinkedList<String> pq = new OrderedLinkedList();
    pq.insert("this");
    pq.insert("is");
    pq.insert("a");
    pq.insert("z");
    pq.insert("test");
    while (!pq.isEmpty()){
      String item = pq.delMax();
      System.out.println(item);
    }
  }
}
