package geekbang.u40;

/**
 * Created by HuGuodong on 2019-10-27.
 */
public class PackDPv1 {

  /**
   * DP: O(n*w), Space n*w
   *
   * @param p
   * @return
   */
  public static int knapack(PackProblem p) {
    boolean[][] states = new boolean[p.n][p.maxWeight + 1];
    states[0][0] = true;
    if (p.items[0] <= p.maxWeight)
      states[0][p.items[0]] = true;
    for (int i = 1; i < p.n; i++) {
      for (int j = 0; j < p.maxWeight; j++) {
        if (states[i - 1][j]) {
          states[i][j] = true; // do not put item-i into pack
        }
      }
      for (int j = 0; j <= p.maxWeight - p.items[i]; j++) {
        if (states[i - 1][j])
          states[i][j + p.items[i]] = true; // put item-i into pack
      }
    }
    for (int i = p.maxWeight; i >= 0; i--) {
      if (states[p.n - 1][i])
        return i;
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] weight = {2, 2, 4, 6, 3};
    PackProblem p = new PackProblem(weight, 9);
    System.out.printf("weight is %2d%n", knapack(p));
  }
}
