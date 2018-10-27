package Ch_2_4;

import static tools.ArrayGenerator.ascIntArray;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/10/24.
 */

public class Ex_2_4_13 {

  static class MaxPQ<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N;

    public MaxPQ(int size){
      pq = (Key[])new Comparable[size + 1];
    }

    public int size(){
      return N;
    }

    public boolean isEmpty(){
      return N == 0;
    }

    public Key delMax(){
      Key max = pq[1];
      pq[1] = pq[N--];  // 使用 pq[N] 作为哨兵
      sink(1);
      pq[N + 1] = null;
      assert isMaxHeap();
      return max;
    }

    public void insert(Key v){
      pq[++N] = v;
      swim(N);
    }

    public void sink(int k){
      while (2*k <= N){
        int j = 2*k;
        if( less(j, j+1)) j++;
        if(!less(k,j)) break;
        exch(k,j);
        k = j;
      }

    }

    public void swim(int k){
      while(k>1 && less(k/2, k)){
        exch(k/2,k);
        k /= 2;
      }
    }

    public boolean less(int i, int j){
      return pq[i].compareTo(pq[j]) < 0;
    }

    public void exch(int i, int j){
      Key temp = pq[i];
      pq[i] = pq[j];
      pq[j] = temp;
    }

    public void show(){
      for(int i=1; i<=N; i++){
        StdOut.printf(pq[i] + "\t");
      }
      StdOut.println();
    }

    // is pq[1..N] a max heap?
    private boolean isMaxHeap() {
      return isMaxHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a max heap?
    private boolean isMaxHeap(int k) {
      if (k > N) return true;
      int left = 2*k;
      int right = 2*k + 1;
      if (left  <= N && less(k, left))  return false;
      if (right <= N && less(k, right)) return false;
      return isMaxHeap(left) && isMaxHeap(right);
    }

  }

  public static void main(String[] args) {
    MaxPQ<Integer> pq = new MaxPQ<>(10);
    Integer[] arr = ascIntArray(10);
    for(int i=0; i<arr.length; i++){
      pq.insert(i);
    }
    while (!pq.isEmpty()){
      StdOut.print(pq.delMax());
    }

  }

}
