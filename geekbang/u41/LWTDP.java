package geekbang.u41;

import tools._Math;

/**
 * Created by HuGuodong on 2019/11/3.
 */
public class LWTDP {

  public int lwtDP(char[] a, int n, char[] b, int m) {
    int[][] minDist = new int[n][m];
    for (int j = 0; j < m; j++) {
      if (a[0] == b[j])
        minDist[0][j] = j;
      else if (j != 0)
        minDist[0][j] = minDist[0][j - 1] + 1;
      else
        minDist[0][j] = 1;
    }

    for (int i = 0; i < n; i++) {
      if (b[0] == a[i])
        minDist[i][0] = i;
      else if (i != 0)
        minDist[i][0] = minDist[i - 1][0] + 1;
      else
        minDist[i][0] = 1;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (a[i] == b[j])
          minDist[i][j] = _Math
              .min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
        else
          minDist[i][j] = _Math
              .min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
      }
    }
    return minDist[n - 1][m - 1];
  }

  public static void main(String[] args) {
    LWTDP l = new LWTDP();
    char[] a = "mitcmu".toCharArray();
    int n = a.length;
    char[] b = "mtacnu".toCharArray();
    int m = b.length;
    System.out.println(l.lwtDP(a, n, b, m));

  }
}
