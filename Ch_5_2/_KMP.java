package Ch_5_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/2/28.
 */

public class _KMP {

  // DFA version: 确定有限状态机

  private String pat;

  private int M;

  private int[][] dfa;

  private int R = 256;

  public _KMP(String pat) {
    this.pat = pat;
    M = pat.length();
    dfa = new int[R][M];
    dfa[pat.charAt(0)][0] = 1;
    for (int X = 0, j = 1; j < M; j++) {
      for (int c = 0; c < R; c++) {
        dfa[c][j] = dfa[c][X]; // copy mismatch cases
      }
      dfa[pat.charAt(j)][j] = j + 1;// set match case
      X = dfa[pat.charAt(j)][X]; // update restart state
    }
  }

  public int search(String txt) {
    int i, j, N = txt.length();
    for (i = 0, j = 0; i < N && j < M; i++) {
      j = dfa[txt.charAt(i)][j];
    }
    if (j == M)
      return i - M;
    else
      return N;
  }

  public static void main(String[] args) {
    String pat = "baa";
    String txt = "aaaaaaabaaaa";
    _KMP kmp = new _KMP(pat);
    int n = kmp.search(txt);
    StdOut.println(txt);
    for (int i = 0; i < n; i++) {
      StdOut.print(" ");
    }
    StdOut.println(pat);
  }

}
