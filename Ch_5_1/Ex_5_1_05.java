package Ch_5_1;

import static Ch_5_1.Ex_5_1_05._MSD.show;
import static Ch_5_1.Ex_5_1_05._MSD.sort;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/1/30.
 */

public class Ex_5_1_05 {

  public static class _MSD {

    public static final int R = 26;

    private static String[] aux;

    private static int charAt(String s, int d) {
      if (d < s.length()) {
        return _Alphabet.LOWERCASE.toIndex(s.charAt(d));
      } else {
        return -1;
      }
    }

    public static void sort(String[] a) {
      int N = a.length;
      aux = new String[N];
      sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
      if (hi <= lo) {
        return;
      }

      int[] count = new int[R + 2];

      for (int i = lo; i <= hi; i++) {
        count[charAt(a[i], d) + 2]++;
      }

      for (int r = 0; r < R + 1; r++) {
        count[r + 1] += count[r];
      }

      for (int i = lo; i <= hi; i++) {
        aux[count[charAt(a[i], d) + 1]++] = a[i];
      }
      for (int i = lo; i <= hi; i++) {
        a[i] = aux[i - lo];
      }

      // show trace 显示轨迹
      StdOut.printf("sort(a, %2d, %2d, %2d): ", lo, hi, d);
      show(a);

      for (int r = 0; r < R; r++) {
        sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
      }

    }

    public static void show(String[] a){
      for (String s : a){
        StdOut.print(s + "\t");
      }
      StdOut.println();
    }
  }


  public static void main(String[] args) {
    String[] a = "now is the time for all good people to come to the aid of".split(" ");
    sort(a);
    show(a);

//    sort(a,  0, 13,  0): all	aid	come	for	good	is	now	of	people	the	time	to	to	the
//    sort(a,  0,  1,  1): aid	all	come	for	good	is	now	of	people	the	time	to	to	the
//    sort(a,  9, 13,  1): aid	all	come	for	good	is	now	of	people	the	the	time	to	to
//    sort(a,  9, 10,  2): aid	all	come	for	good	is	now	of	people	the	the	time	to	to
//    sort(a,  9, 10,  3): aid	all	come	for	good	is	now	of	people	the	the	time	to	to
//    sort(a, 12, 13,  2): aid	all	come	for	good	is	now	of	people	the	the	time	to	to


  }

}
