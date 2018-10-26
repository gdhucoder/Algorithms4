package Ch_2_4;

import static tools.ArrayGenerator.ascIntArray;
import static tools.ArrayGenerator.descIntArray;
import static tools.ArrayGenerator.fixedValueIntArray;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/10/24.
 */

public class _Heap {

  private _Heap(){}
  public static int count;

  public static void sort(Comparable[] pq){
    int N = pq.length;
    for(int k=N/2; k>=1; k--){
      sink(pq,k,N);
    }
    while(N>1){
      exch(pq,1,N--);
      sink(pq,1,N);
    }
  }

  private static void sink(Comparable[] pq, int k, int n){
    while(2*k <=n){
      int j = 2*k;
      if(j<n && less(pq, j, j+1)) j++;
      if(!less(pq,k,j)) break;
      exch(pq,k,j);
      k=j;
    }
  }

  private static boolean less(Comparable[] pq, int i, int j){
    count++;
    return pq[i-1].compareTo(pq[j-1]) < 0;
  }

  private static void exch(Object[] pq, int i, int j){
    Object swap = pq[i-1];
    pq[i-1] = pq[j-1];
    pq[j-1] = swap;
  }

  private static void show(Comparable[] pq){
    for(int i=0; i<pq.length; i++){
      StdOut.print(pq[i] + " ");
    }
    StdOut.println();
  }

  public static void main(String[] args) {
    Integer[] arr = ascIntArray(33);
    StdOut.println(arr.length);
    show(arr);
    sort(arr);
    show(arr);
    StdOut.println("count: " + count);
    count = 0;

    arr = descIntArray(32);
    StdOut.println(arr.length);
    show(arr);
    sort(arr);
    show(arr);
    StdOut.println("count: " + count);
    count = 0;

    arr = fixedValueIntArray(1,32);
    StdOut.println(arr.length);
    show(arr);
    sort(arr);
    show(arr);
    StdOut.println("count: " + count);
  }

}
