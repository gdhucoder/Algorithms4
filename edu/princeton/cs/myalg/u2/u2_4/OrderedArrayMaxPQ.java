package edu.princeton.cs.myalg.u2.u2_4;

/**
 * Created by HuGuodong on 2018/10/13.
 */

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {

  private Key[] pq;
  private int n;

  public OrderedArrayMaxPQ(int capacity){
    pq = (Key[])new Comparable[capacity];
    n = 0;
  }

  public boolean isEmpty(){
    return n == 0;
  }

  public int size(){
    return n;
  }

//  public void insert(Key key){
//    pq[++n] = key;
//    int i = n-1;
//    while(i>0 && less(n, i)){
//      pq[i+1] = pq[i];
//      i--;
//    }
//    pq[i] = key;
//  }

  public void insert(Key key){
    int i = n - 1; // the last ele
    while(i>=0 && less(key, pq[i])){
      pq[i+1] = pq[i];
      i--;
    }
    pq[i+1] = key;
    n++; // n = all elements + a vacant position
  }


  public Key delMax(){
    return pq[--n];
  }

  /***************************************************************************
   * Helper functions.
   ***************************************************************************/

  public boolean less(int i, int j){
    return pq[i].compareTo(pq[j]) < 0;
  }

  public boolean less(Key a, Key b){
    return a.compareTo(b) < 0;
  }

  /***************************************************************************
   * Test routine.
   ***************************************************************************/
  public static void main(String[] args) {
    OrderedArrayMaxPQ<String> pq = new OrderedArrayMaxPQ(10);
    pq.insert("this");
    pq.insert("is");
    pq.insert("a");
    pq.insert("test");
    while (!pq.isEmpty()){
      String item = pq.delMax();
      System.out.println(item);
    }
  }
}
