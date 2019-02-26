package Ch_5_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/2/26.
 */

public class _BFSearch {

  public static int search(String txt, String pat) {
    int N = txt.length();
    int M = pat.length();
    for (int i = 0; i <= N - M; i++) {
      int j;
      for (j = 0; j < M; j++) {
        if (txt.charAt(i + j) != pat.charAt(j))
          break;
      }
      if (j == M)
        return i;
    }
    return N;
  }


  public static int search2(String txt, String pat) {
    int N = txt.length();
    int M = pat.length();
    // i points to end of substring
    int i, j;
    for (i = 0, j = 0; i < N && j < M; i++) {
      if (txt.charAt(i) == pat.charAt(j)) {
        j++; // match
      } else {
        i -= j; // miss match
        j = 0;
      }
    }

    if (j == M)
      return i - M; // found
    else
      return N; // not found
  }

  public static void showSearch(String txt, String pat, int n) {
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
    String txt = "aabbccdd";
    String pat = "d";
    StdOut.println(txt);
    int n = search(txt, pat);
    showSearch(txt, pat, n);

    n = search2(txt, pat);
    showSearch(txt, pat, n);


  }

}
