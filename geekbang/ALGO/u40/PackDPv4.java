package geekbang.ALGO.u40;

import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/10/30.
 */
public class PackDPv4 {

  public static void double11(int[] items, int n, int w) {
    boolean[][] states = new boolean[n][3 * w + 1];
    states[0][0] = true;
    if (items[0] <= 3 * w) {
      states[0][items[0]] = true;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= 3 * w; j++) {
        if (states[i - 1][j]) {
          states[i][j] = true;
        }
      }
      for (int j = 0; j <= 3 * w - items[i]; j++) {
        if (states[i - 1][j]) {
          states[i][j + items[i]] = true;
        }
      }
    }
    int j;
    for (j = w; j < 3 * w + 1; j++) {
      if (states[n - 1][j])
        break;
    }
    if (j == 3 * w + 1)
      return;

    for (int i = n - 1; i >= 1; i--) {
      if (j - items[i] >= 0 && states[i - 1][j - items[i]] == true) {
        System.out.print(items[i] + " ");
        j = j - items[i];
      }

    }

    if (j != 0) {
      System.out.println(items[0]);
    }

    System.out.println();

  }

  public static void main(String[] args) {
    int[] item = ArrayGenerator.randomIntsArray(20);
    PrintUtil.show(item);
    double11(item, item.length, 20);

  }

}
