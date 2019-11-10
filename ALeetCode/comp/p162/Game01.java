package ALeetCode.comp.p162;

/**
 * Created by HuGuodong on 2019/11/10.
 */
public class Game01 {

  public static int oddCells(int n, int m, int[][] indices) {
    int[][] a = new int[n][m];
    for (int r = 0; r < indices.length; r++) {
      int idx_i = indices[r][0];
      int idx_j = indices[r][1];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (i == idx_i) {
            a[i][j] += 1;
          }
          if (j == idx_j) {
            a[i][j] += 1;
          }
        }
      }
    }
    int ret = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] % 2 == 1) {
          ret++;
        }
      }
    }
//    PrintUtil.show(a);
    return ret;
  }

  public static void main(String[] args) {
    int[][] idx = {{0, 1}, {1, 1}};
    oddCells(2, 3, idx);
  }

}
