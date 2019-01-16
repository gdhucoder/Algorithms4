package Ch_5_1;

import static edu.princeton.cs.algs4.StdIn.*;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by HuGuodong on 2019/1/15.
 */

public class _LSD {

  public static void sort(String a[], int W) {
    int N = a.length;
    int R = 256;
    String[] aux = new String[N];

    for (int d = W - 1; d >= 0; d--) {
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

  public static void main(String[] args) throws Exception {
    System.setIn(
        new FileInputStream("E:\\gitspace\\x1c\\Alg4\\algs4\\src\\main\\algs4-data\\words3.txt"));
    String[] a = readAllStrings();
    int n = a.length;

    // check that strings have fixed length
    int w = a[0].length();
    for (int i = 0; i < n; i++)
      assert a[i].length() == w : "Strings must have fixed length";

    sort(a, w);
    for (String item : a) {
      StdOut.println(item);
    }
  }

}
