package Ch_5_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/2/27.
 */

public class _BM {


  public static int[] getRight(String pat) {
    int R = 256;
    int[] right = new int[R];
    for (int i = 0; i < R; i++) {
      right[i] = -1;
    }
    for (int i = 0; i < pat.length(); i++) {
      right[pat.charAt(i)] = i;
    }
    return right;
  }

  public static int search(String txt, String pat, int[] right) {
    int N = txt.length();
    int M = pat.length();
    int skip;
    for (int i = 0; i <= N - M; i += skip) {
      skip = 0;
      for (int j = M - 1; j >= 0; j--) {
        if (txt.charAt(i + j) != pat.charAt(j)) {
          skip = j - right[txt.charAt(j)];
          if (skip < 1) {
            skip = 1;
          }
          break;
        }
      }
      if (skip == 0) { // found
        return i;
      }
    }
    return N;
  }

  public static void showSearch(String txt, String pat, int n) {
    StdOut.println(txt);
    if (n >= 0 && n < txt.length()) {
      for (int i = 0; i < n; i++) {
        StdOut.print(" ");
      }
      StdOut.println(pat);
    } else {
      StdOut.println("pat not found!");
    }
  }

  public static void main(String[] args) {
    String txt = "aaabaaabaaaa";
    String pat = "aaaa";
    int[] right = getRight(pat);
    int n = search(txt, pat, right);
    showSearch(txt, pat, n);
//    aaabaaabaaaa
//            aaaa

  }

}
