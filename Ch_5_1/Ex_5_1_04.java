package Ch_5_1;

import static Ch_5_1.Ex_5_1_04._Quick3String.sort;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/1/29.
 */

public class Ex_5_1_04 {

  public static class _Quick3String {

    public static int charAt(String s, int d) {
      if (d < s.length()) {
        return s.charAt(d);
      } else {
        return -1;
      }
    }

    public static void sort(String[] a) {
      int N = a.length;
      sort(a, 0, N - 1, 0);
    }

    public static void sort(String[] a, int lo, int hi, int d) {
      if (hi <= lo) {
        return;
      }
      StdOut.printf("sort(%2d, %2d, %2d): ", lo, hi, d);
      show(a);
      int lt = lo, gt = hi;
      int v = charAt(a[lt], d);
      int i = lt + 1;
      while (i <= gt) {
        int t = charAt(a[i], d);
        if (t < v) {
          exch(a, lt++, i++);
        } else if (t > v) {
          exch(a, i, gt--);
        } else {
          i++;
        }
      }

      sort(a, lo, lt - 1, d);
      if (v >= 0) {
        sort(a, lt, gt, d + 1);
      }
      sort(a, gt + 1, hi, d);

    }

    private static void exch(String[] a, int i, int j) {
      String temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }

    public static void show(String[] a){
      for (String s : a){
        StdOut.print(s+"\t");
      }
      StdOut.println();
    }


  }

  public static void main(String[] args) {
    String[] a = "no is th ti fo al go pe to co to th ai of th pa".split(" ");
    sort(a);
//    sort( 0, 15,  0): no	is	th	ti	fo	al	go	pe	to	co	to	th	ai	of	th	pa
//    sort( 0,  5,  0): is	ai	co	fo	al	go	no	to	pe	to	th	ti	of	th	pa	th
//    sort( 0,  4,  0): ai	co	fo	al	go	is	no	to	pe	to	th	ti	of	th	pa	th
//    sort( 0,  1,  1): ai	al	fo	go	co	is	no	to	pe	to	th	ti	of	th	pa	th
//    sort( 2,  4,  0): ai	al	fo	go	co	is	no	to	pe	to	th	ti	of	th	pa	th
//    sort( 7, 15,  0): ai	al	co	fo	go	is	no	to	pe	to	th	ti	of	th	pa	th
//    sort( 7,  9,  0): ai	al	co	fo	go	is	no	pe	of	pa	th	ti	to	th	to	th
//    sort( 8,  9,  1): ai	al	co	fo	go	is	no	of	pe	pa	th	ti	to	th	to	th
//    sort(10, 15,  1): ai	al	co	fo	go	is	no	of	pa	pe	th	ti	to	th	to	th
//    sort(10, 12,  2): ai	al	co	fo	go	is	no	of	pa	pe	th	th	th	to	to	ti
//    sort(13, 15,  1): ai	al	co	fo	go	is	no	of	pa	pe	th	th	th	to	to	ti
//    sort(14, 15,  2): ai	al	co	fo	go	is	no	of	pa	pe	th	th	th	ti	to	to
  }

}
