package edu.princeton.cs.myalg.u2.u2_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/10/17.
 */

public class UnorderedLinkedList<Key extends Comparable<Key>> {

  private Node first;
  private int N;

  public boolean isEmpty(){
    return N == 0; // or N == 0
  }

  private int size(){
    return N;
  }

  public void insert(Key v){
    Node oldfirst = first;
    first = new Node();
    first.item = v;
    first.next = oldfirst;
    N++;
  }

  public Key delMax(){
    Node max = first;
    Node prev = first;
    Node temp = null;

    while (prev.next!=null){
      if(less(max.item, prev.next.item)){
        max = prev.next;
        temp = prev;
      }
      prev = prev.next;
    }

    if(temp==null){ // means the biggest is the first element
      first=first.next;
    }else if(temp.next.next!=null){ // means the biggest is in the middle of the linkedlist
      temp.next = temp.next.next;
    }else{// means the biggest is at the end of inkedlist
      temp.next = null;
    }

    System.out.println("max: "+ max.item);
    N--;
    return max.item;
  }

  private boolean less(Key a, Key b){
    return a.compareTo(b)<0;
  }


  private class Node{
    Key item;
    Node next;
  }

  public static void main(String[] args) {
    UnorderedLinkedList<String> pq = new UnorderedLinkedList();
    pq.insert("this");
    pq.insert("is");
    pq.insert("a");
    pq.insert("z");
    pq.insert("test");

    UnorderedLinkedList<Integer> q = new UnorderedLinkedList();
    q.insert(6);
    q.insert(9);
    q.insert(1);
    q.insert(3);
    q.insert(10);
    while (!q.isEmpty()){
      Integer item = q.delMax();
      System.out.println(item);
    }
  }

}
