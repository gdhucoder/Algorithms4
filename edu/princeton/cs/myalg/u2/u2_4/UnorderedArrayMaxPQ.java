package edu.princeton.cs.myalg.u2.u2_4;

/**
 * Priority queue implementation with an unsorted array.
 * Limitations
 * no resizing
 * do not check overflow or underflow
 * Created by HuGuodong on 2018/10/13.
 */

public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {

  private Key[] pq; // elements
  private int n; // number of elements

  public UnorderedArrayMaxPQ(int capacity){
    pq = (Key[]) new Comparable[capacity];
    n = 0;
  }

  public boolean isEmptiy(){
    return n == 0;
  }

  public int size(){
    return n;
  }

  public void insert(Key x){
    pq[n++] = x;
  }

  public Key delMax(){
    int max = 0;
    for(int i=0; i<n; i++){
      if(less(max, i)){
        max = i;
      }
    }
    exch(max, n-1);
    return pq[--n];
  }


  /***************************************************************************
   * Helper functions.
   ***************************************************************************/

  public boolean less(int i, int j){
    return pq[i].compareTo(pq[j]) < 0;
  }

  public void exch(int i, int j){
    Key swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
  }

  /***************************************************************************
   * Test routine.
   ***************************************************************************/
  public static void main(String[] args) {
    UnorderedArrayMaxPQ<String> pq = new UnorderedArrayMaxPQ(10);
    pq.insert("this");
    pq.insert("is");
    pq.insert("a");
    pq.insert("test");
    while (!pq.isEmptiy()){
      String item = pq.delMax();
      System.out.println(item);
    }
  }

}
