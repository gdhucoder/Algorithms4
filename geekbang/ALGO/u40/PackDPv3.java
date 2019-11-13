package geekbang.ALGO.u40;

/**
 * Created by HuGuodong on 2019-10-29.
 */
public class PackDPv3 {

  private int maxV = Integer.MIN_VALUE;
  private int[] items = {2, 2, 4, 6, 3};
  private int[] value = {3, 4, 8, 9, 6};
  private int n = 5;
  private int w = 9;

  public int kanpsack3(int[] weight, int[] value, int n, int w) {
    int[][] states = new int[n][w + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < w + 1; j++) {
        states[i][j] = -1;
      }
    }
    states[0][0] = 0;
    if (weight[0] < w) {
      states[0][weight[0]] = value[0];
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= w; j++) {
        if (states[i - 1][j] >= 0)
          states[i][j] = states[i - 1][j];
      }
      for (int j = 0; j <= w - weight[i]; j++) {
        if (states[i][j] >= 0) {
          int v = states[i - 1][j] + value[i];
          if (v > states[i][j + weight[i]]) // put
            states[i][j + weight[i]] = v;
        }

      }
    }
    int maxValue = -1;
    for (int i = 0; i <= w; i++) {
      if (states[n - 1][i] > maxValue)
        maxValue = states[n - 1][i];
    }
    return maxValue;
  }

  public int kanpsack4(int[] weight, int[] value, int n, int w) {
    int[] states = new int[w + 1];
    for (int i = 0; i <= w; i++) {
      states[i] = -1;
    }
    states[0] = 0;
    if (weight[0] <= w) {
      states[weight[0]] = value[0];
    }
    for (int i = 1; i < n; i++) {
      for (int j = w - weight[i]; j >= 0; j--) {
        if (states[j] >= 0) {
          int v = states[j] + value[i];
          if (v > states[j + weight[i]]) // put
            states[j + weight[i]] = v;
        }
      }
    }
    int maxValue = -1;
    for (int i = 0; i <= w; i++) {
      if (states[i] > maxValue)
        maxValue = states[i];
    }
    return maxValue;
  }

  public static void main(String[] args) {
    PackDPv3 p = new PackDPv3();
    int maxValue = p.kanpsack4(p.items, p.value, p.n, p.w);
    System.out.printf("%2d%n", maxValue);
    maxValue = p.kanpsack3(p.items, p.value, p.n, p.w);
    System.out.printf("%2d%n", maxValue);
  }
}
