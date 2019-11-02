package geekbang.u41;

/**
 * Created by HuGuodong on 2019/11/2.
 */
public class Coin {

  private int[] coins = {1, 3, 5};
  private int[] mem = new int[20 + 1];


  public int backTracking(int max) {
    if (max == 0) {
      return 0;
    }
    if (max < 0) {
      System.out.println(max);
      return Integer.MAX_VALUE;
    }
    if (mem[max] > 0) {
      System.out.println("hit mem: " + max + "->" + mem[max]);
      return mem[max];

    }
    int cnt0 = backTracking(max - coins[0]);// possible = Integer.MAX_VALUE
    int cnt1 = backTracking(max - coins[1]);
    int cnt2 = backTracking(max - coins[2]);
    int count = Math.min(Math.min(cnt0, cnt1), cnt2) + 1;
    mem[max] = count;
    return Math.min(Math.min(cnt0, cnt1), cnt2) + 1;
  }

  public static void main(String[] args) {
    Coin c = new Coin();
    System.out.println(c.backTracking(10));
  }
}
