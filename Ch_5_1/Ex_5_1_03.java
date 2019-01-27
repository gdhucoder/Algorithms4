package Ch_5_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/1/27.
 */

public class Ex_5_1_03 {

  public static class _MSD {

    private static int R = 26;
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

    /**
     * sort from a[lo] to a[hi], starting at each dth character.
     */
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
        int idx = count[charAt(a[i], d) + 1]++;
        aux[idx] = a[i]; // idx 从0开始
//        System.out.println("idx: " + idx + "," + aux[idx]);
      }

      for (int i = lo; i <= hi; i++) {
//        System.out.println("i: " + i + ", :" + (i - lo));
        a[i] = aux[i - lo]; // i-lo 对应从0开始
      }

      // show trace 显示轨迹
      StdOut.printf("sort(a, %2d, %2d, %2d): ", lo, hi, d);
      show(a);

      for (int r = 0; r < R; r++) {
        sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
      }

    }

  }


  /**
   * 5_1_03
   */
  public static void testSort(){
    String str = "no is th ti fo al go pe to co to th ai of th pa";
    String[] a = str.split(" ");
    show(a);
    _MSD.sort(a);
    show(a);
  }

  public static void show(String[] a){
    for (String s : a) {
      StdOut.print(s + "\t");
    }
    StdOut.println();
  }

  public static void main(String[] args) {
    testSort();

//    no	is	th	ti	fo	al	go	pe	to	co	to	th	ai	of	th	pa
//    sort(a,  0, 15,  0): al	ai	co	fo	go	is	no	of	pe	pa	th	ti	to	to	th	th
//    sort(a,  0,  1,  1): ai	al	co	fo	go	is	no	of	pe	pa	th	ti	to	to	th	th
//    sort(a,  8,  9,  1): ai	al	co	fo	go	is	no	of	pa	pe	th	ti	to	to	th	th
//    sort(a, 10, 15,  1): ai	al	co	fo	go	is	no	of	pa	pe	th	th	th	ti	to	to
//    sort(a, 10, 12,  2): ai	al	co	fo	go	is	no	of	pa	pe	th	th	th	ti	to	to
//    sort(a, 14, 15,  2): ai	al	co	fo	go	is	no	of	pa	pe	th	th	th	ti	to	to
//    ai	al	co	fo	go	is	no	of	pa	pe	th	th	th	ti	to	to
  }
}
