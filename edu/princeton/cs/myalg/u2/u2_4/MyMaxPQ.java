package edu.princeton.cs.myalg.u2.u2_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/10/13.
 */

public class MyMaxPQ<Key extends Comparable<Key>> {

  private Key[] pq;
  private int N = 0;

  public MyMaxPQ(int maxN){
    pq = (Key[])new Comparable[maxN+1];
  }

  public boolean isEmpty(){
    return N==0;
  }

  public int size(){
    return N;
  }

  public void insert(Key v){
    pq[++N] = v;
    swim(N);
  }

  public Key delMax(){
    Key max = pq[1];
    exch(1,N--);
    pq[N+1] = null;
    sink(1);
    return max;
  }

  private boolean less(int i, int j){
    return pq[i].compareTo((pq[j])) < 0;
  }

  private void exch(int i, int j){
    Key swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
  }

  public void swim(int k){
    while(k>1 && less(k/2, k)){
      exch(k/2, k);
      k = k / 2;
    }
  }

  public void sink(int k){
    while(2*k <= N){
      int j = 2*k;
      if(j<N && less(j,j+1)) j++;
      if(!less(k,j)) break;
      exch(k,j);
      k = j;
    }
  }

  public static void main(String[] args) {
    MyMaxPQ<String> pq = new MyMaxPQ<>(10);
    while(!StdIn.isEmpty()){
      String item = StdIn.readString();
      if(!item.equals("-")){
        pq.insert(item);
      }else if(!pq.isEmpty()){
        StdOut.print(pq.delMax()+" ");
      }
    }
    StdOut.println("(" + pq.size() + " left on pq)");
  }

}
