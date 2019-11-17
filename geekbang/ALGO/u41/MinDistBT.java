package geekbang.ALGO.u41;

/**
 * Created by HuGuodong on 2019/11/17.
 */
public class MinDistBT {

  public static int minDist = Integer.MAX_VALUE;

  /**
   * call minDist(0, 0, a[0][0], a, a.length)
   *
   * @param i    cur row index
   * @param j    cur column index
   * @param dist cur distance,start from a[0][0]
   * @param a    array
   * @param n    length of the input array
   */
  public static void minDistBt(int i, int j, int dist, int[][] a, int n) {
    System.out.printf("%2d %2d\n", i, j);
    if (i == n - 1 && j == n - 1) {
      if (dist < minDist)
        minDist = dist;
      return;
    }

    if (i + 1 < n)
      minDistBt(i + 1, j, dist + a[i + 1][j], a, n);

    if (j + 1 < n)
      minDistBt(i, j + 1, dist + a[i][j + 1], a, n);

  }

  public static void main(String[] args) {
    int[][] a = {{1, 3, 5, 9},
        {2, 1, 3, 4},
        {5, 2, 6, 7},
        {6, 8, 4, 3}};
    minDistBt(0, 0, a[0][0], a, 4);
    System.out.println("Minimum distance is: " + minDist);
  }

}
