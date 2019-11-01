package geekbang.u41;

import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/11/2.
 */
public class Coin {

  private int[] coinTypes = {1, 3, 5};

  public int countCoins(int amount, int cnt, int limit) {
    if (amount == limit) {
      return cnt;
    }
    if (amount > limit) {
      return Integer.MAX_VALUE;
    }

    int cnt1 = countCoins(amount + coinTypes[0], cnt + 1, limit);
    int cnt2 = countCoins(amount + coinTypes[1], cnt + 1, limit);
    int cnt3 = countCoins(amount + coinTypes[2], cnt + 1, limit);
    int c = Math.min(Math.min(cnt1, cnt2), cnt3);

    return c;
  }

  public static void main(String[] args) {
    Coin c = new Coin();
    System.out.println(c.countCoins(0, 0, 20));
  }
}
