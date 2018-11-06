package Ch_2_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/6.
 */

public abstract class _Sort {

  public abstract void sort(Comparable[] a);

  public boolean less(Comparable a, Comparable b){
    return a.compareTo(b) < 0;
  }

  public void exch(Object[] a, int i, int j){
    Object temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public void show(Object[] a){
    for(int i=0; i<a.length; i++){
      StdOut.printf("%5s\t", a[i].toString());
    }
    StdOut.println();
  }

  public boolean isSorted(Comparable[] a){
    for(int i=1; i<a.length; i++){
      if(less(a[i], a[i-1])) return false;
    }
    return true;
  }
}
