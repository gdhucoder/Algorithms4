package Ch_5_1;

import edu.princeton.cs.algs4.Alphabet;
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
        return _Alphabet.LOWERCASE.toIndices(s)[d];
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
        System.out.println("idx: " + idx + "," + aux[idx]);
      }

      for (int i = lo; i <= hi; i++) {
        System.out.println("i: " + i + ", :" + (i - lo));
        a[i] = aux[i - lo]; // i-lo 对应从0开始
      }

      for (int r = 0; r < R; r++) {
        sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
      }

    }

  }

  public static void main(String[] args) {
    String str = "she, shells, seashells, by, the, sea, shore, the, shells, she, shells, are, surely, seashells";
    String[] strings = str.replaceAll(" ", "").split(",");

    for (String s : strings) {
      StdOut.print(s + "\t");
    }
    StdOut.println();

    _MSD.sort(strings);

    for (String s : strings) {
      StdOut.print(s + "\t");
    }
    StdOut.println();

  }
}
