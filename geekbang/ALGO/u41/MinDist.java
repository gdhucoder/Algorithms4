package geekbang.ALGO.u41;

/**
 * Created by HuGuodong on 2019/11/16.
 */
public class MinDist {

  public static int minDist = Integer.MAX_VALUE;

  public static int minDist(int[][] a) {
    int n = a.length;
    int[][] states = new int[n][n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += a[i][0];
      states[i][0] = sum;
    }
    sum = 0;
    for (int i = 0; i < n; i++) {
      sum += a[0][i];
      states[0][i] = sum;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        states[i][j] = a[i][j] + Math.min(states[i - 1][j], states[i][j - 1]);
      }
    }
    return states[n - 1][n - 1];
  }

  ;

  public static void main(String[] args) {
    int[][] a = {{1, 3, 5, 9},
        {2, 1, 3, 4},
        {5, 2, 6, 7},
        {6, 8, 4, 3}};
    int minDist = minDist(a);
    System.out.println("Minimum distance is: " + minDist);
  }
}
