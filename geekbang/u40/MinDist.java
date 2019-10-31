package geekbang.u40;

/**
 * Created by HuGuodong on 2019/11/1.
 */
public class MinDist {

  private int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
  private int n = 4;
  private int[][] mem = new int[4][4];

  public int minDist(int i, int j) {
    if (i == 0 && j == 0)
      return matrix[0][0];
    if (mem[i][j] > 0)
      return mem[i][j];
    int minLeft = Integer.MAX_VALUE;
    if ((j - 1) >= 0)
      minLeft = minDist(i, j - 1);
    int minUp = Integer.MAX_VALUE;
    if ((i - 1) >= 0)
      minUp = minDist(i - 1, j);
    int curMinDist = matrix[i][j] + Math.min(minLeft, minUp);
    mem[i][j] = curMinDist;
    return curMinDist;
  }

  public static void main(String[] args) {
    MinDist min = new MinDist();
    int minDist = min.minDist(3, 3);
    System.out.println(minDist);
  }
}
