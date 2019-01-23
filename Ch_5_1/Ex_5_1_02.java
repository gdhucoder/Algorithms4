package Ch_5_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/1/24.
 */

public class Ex_5_1_02 {

  public static class _LSD{
    public static void sort(String a[], int W) {
      int N = a.length;
      int R = 256;
      String[] aux = new String[N];

      for (int d = W - 1; d >= 0; d--) {
        show(a);
        int[] count = new int[R + 1];
        for (int i = 0; i < N; i++) {
          count[a[i].charAt(d) + 1]++;
        }

        for (int r = 0; r < R; r++) {
          count[r + 1] += count[r];
        }

        for (int i = 0; i < N; i++) {
          aux[count[a[i].charAt(d)]++] = a[i];
        }

        for (int i = 0; i < N; i++) {
          a[i] = aux[i];
        }
      }
    }

    public static void show(Object[] a){
      for(Object o : a){
        StdOut.print(o+"\t");
      }
      StdOut.println();
    }
  }

  public static void main(String[] args) {
    String[] a = "no is th ti fo al go pe to co to th ai of th pa".split(" ");
    _LSD.sort(a, 2);
    _LSD.show(a);
//    no	is	th	ti	fo	al	go	pe	to	co	to	th	ai	of	th	pa
//    pa	pe	of	th	th	th	ti	ai	al	no	fo	go	to	co	to	is
//    ai	al	co	fo	go	is	no	of	pa	pe	th	th	th	ti	to	to
  }
}
