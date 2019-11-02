package geekbang.u41;

import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/11/2.
 */

public class CoinDP {

  public static int DP(int[] coins, int money) {
    if (money <= 0) {
      throw new IllegalArgumentException("limit must be > 0");
    }
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] == money) {
        return 1;
      }
    }
    boolean[][] states = new boolean[money][money + 1];
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= money) {
        states[0][coins[i]] = true;
      }
    }
    for (int i = 1; i < money; i++) {
      for (int j = 1; j < money + 1; j++) {
        for (int k = 0; k < coins.length; k++) {
          if (j + coins[k] <= money && states[i - 1][j])
            states[i][j + coins[k]] = true;
        }
        if (states[i][j] && j == money)
          return i + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] coins = {2, 10};
    System.out.println(DP(coins, 5));
  }
}
