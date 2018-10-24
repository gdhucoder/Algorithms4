package edu.princeton.cs.myalg.u2.u2_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/7/9.
 */

public abstract class Sort {

  public  static void sort(Comparable[] a){

  }

  private static boolean less(Comparable v, Comparable w){
    return v.compareTo(w)<0;
  }

  private static void exch(Comparable[] a, int i, int j){
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static void show(Comparable[] a){
    for(int i=0; i<a.length; i++){
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  public static boolean isSorted(Comparable[] a){
    for(int i=1; i<a.length; i++){
      if(less(a[i],a[i-1])){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String[] a = StdIn.readAllStrings();
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
