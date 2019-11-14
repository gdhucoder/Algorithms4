package geekbang.ALGO.u40.review3;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/11/14.
 */
public class YangHui {

  public int minDist(int[][] a) {
    int m = a.length;
    int n = a[m - 1].length;
    int[][] states = new int[m][n];
    states[0][0] = a[0][0];
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < a[i].length; j++) {
        if (j == 0) {
          states[i][j] = a[i][j] + states[i - 1][j];
        } else if (j == a[i].length - 1) {
          states[i][j] = a[i][j] + states[i - 1][j - 1];
        } else {
          states[i][j] = a[i][j] + Math.min(states[i - 1][j - 1], states[i - 1][j]);
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      if (min > states[m - 1][i]) {
        min = states[m - 1][i];
      }
    }

    PrintUtil.show(states);
    return min;
  }


  public static void main(String[] args) {
    int[][] a = {
        {5},
        {7, 8},
        {2, 3, 4},
        {4, 9, 6, 1},
        {2, 7, 9, 4, 5}};
    YangHui p = new YangHui();

    System.out.println(a[0].length);
//    Answer:
//    5    0    0    0    0
//    12   13    0    0    0
//    14   15   17    0    0
//    18   23   21   18    0
//    20   25   30   22   23

    System.out.println(p.minDist(a));
  }
}
