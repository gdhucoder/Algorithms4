package edu.princeton.cs.myalg.u2.u2_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

/**
 * Created by HuGuodong on 2018/9/12.
 */

public class StatQuick {

  private static int count = 0;
  private static int count_length_zero = 0 ;
  private static int count_length_one = 0 ;
  private static int count_length_two = 0 ;
  private static boolean SHUFFLE = true;

  public static void sort(Comparable[] a) {
    if(SHUFFLE){
      StdRandom.shuffle(a);
    }
    sort(a, 0, a.length - 1);
//    assert isSorted(a);
  }

  private static void sort(Comparable[] a, int lo, int hi) {

    int length = hi - lo + 1;
    if(length <= 0 ){
      count_length_zero ++;
    }
    if(length == 1){
      count_length_one ++;
    }
    if(length == 2){
      count_length_two ++;
    }

    if (hi <= lo) {
      count++;
      return;
    }
    int j = partition(a, lo, hi);

    StdOut.printf("%d ", j);
    show(a);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
//    assert isSorted(a, lo, hi);
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi + 1;
    Comparable v = a[lo];
    while (true) {
      while (less(a[++i], v)) {
        if (i == hi) {
          count++;
          break;
        }
      }

      while (less(v, a[--j])) {
        if (j == lo) {
          count++;
          break;
        }
      }
      // check if pointers cross
      if (i >= j) {
        count++;
        break;
      }

      exch(a, i, j);
    }
    // put partitioning item v at a[j]
    exch(a, lo, j);

    return j;
  }

  private static void exch(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  private static boolean less(Comparable v, Comparable w) {
    count++;
    if (v == w) {
      return false;
    }
    return v.compareTo(w) < 0;
  }


  private static boolean isSorted(Comparable[] a) {
    return isSorted(a, 0, a.length - 1);
  }

  private static boolean isSorted(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  public static void show(Comparable[] a) {
    for (Comparable ele : a) {
      StdOut.print(ele + "\t\t");
    }
    StdOut.println();
  }

  @Test
  public void Q1(){
    String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
    partition(a, 0, a.length -1);
    show(a);
  }

  @Test
  public void Q2(){
    String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
    sort(a);
    show(a);
  }

  @Test
  public void Q7(){
    StdOut.printf("N:%7s %7d %7s %7s\n", "N",
        0,  1, 2);
    int N = 1000;
    int trialTime = 100;
    for(int i=0; i< 5; i++){
      count_length_zero = 0;
      count_length_one=0;
      count_length_two=0;
      Integer[] a = new Integer[N];
      for (int j = 0; j < trialTime; j++) {
        for(int k=0; k<N; k++){
          a[k] = k;
        }
        sort(a);
      }
      StdOut.printf("N:%7d %7d %7d %7d\n", N,
          count_length_zero/trialTime, count_length_one/trialTime,count_length_two/trialTime);
      N*=2;
    }
  }

  @Test
  public void Q6(){
    int N = 100;
    int trialTime = 100;
    int totalCount = 0;
    for(int i=0; i< 3; i++){
      Integer[] a = new Integer[N];
      for (int j = 0; j < trialTime; j++) {
        count = 0;
        for(int k=0; k<N; k++){
          a[k] = k;
        }
        sort(a);
        totalCount+=count;
      }
      StdOut.printf("N: %7d, %10.2f\n", totalCount/trialTime, 2*N*Math.log(N));
      N*=10;
    }
  }

  @Test
  public void Q8() {

    int N = 4;

    for (int i = 0; i < 10; i++) {
      String[] a = new String[N];
      count = 0;
      for (int k = 0; k < N; k++) {
        a[k] = "a";
      }
      sort(a);
      StdOut.printf("N: %7d, %7d, %10.2f\n", N, count,(N+1)*Math.log(N)/Math.log(2));
      N *= 2;
    }
  }


  @Test
  public void Q9_1(){
    SHUFFLE = false;
    String s = "1000222000222000222";
    int n = s.length();
    String[] a = new String[s.length()];
    for (int i = 0; i < n; i++) {
      a[i] = s.substring(i, i + 1); // indexOf 返回的是char类型
    }
    // sort a print results
    sort(a);
    for (int i = 0; i < n; i++) {
      StdOut.print(a[i]);
    }
    StdOut.println();
  }

  public static void main(String[] args) {
    Integer[] a = new Integer[10];
    for (int i = 0; i < 10; i++) {
      a[i] = StdRandom.uniform(100);
    }
    sort(a);
    show(a);
  }

}
