package geekbang.ALGO.u40.review3;

/**
 * Created by HuGuodong on 2019/11/14.
 */
public class DP_double11 {

  public void calcSum(int[] items, int n, int w) {
    boolean[][] states = new boolean[n][3 * w + 1];
    states[0][0] = true;
    if (items[0] < 3 * w) {
      states[0][items[0]] = true;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < 3 * w; j++) {
        if (states[i - 1][j] == true)
          states[i][j] = true; // not include
      }
      for (int j = 0; j < 3 * w; j++) {
        if (j + items[i] < 3 * w) {
          if (states[i - 1][j] == true) {
            states[i][j + items[i]] = true;
          }
        }
      }
    }

    int j = 0;
    for (j = w; j < 3 * w; j++) {
      if (states[n - 1][j] == true) {
        break;
      }
    }

    System.out.println("max is " + j);
    // j

    for (int i = n - 1; i >= 1; i--) {
      if (j - items[i] >= 0 && states[i - 1][j - items[i]] == true) {
        System.out.printf("%2d ", items[i]);
        j = j - items[i];
      }

    }

    if (j != 0) {// row 0, we buy items[0]
      System.out.printf("%2d ", items[0]);
    }

  }

  public static void main(String[] args) {
    DP_double11 p = new DP_double11();
    int[] items = {10, 20, 30, 40, 100};
    int w = 50;
    int n = items.length;
    p.calcSum(items, n, w);
  }
}
