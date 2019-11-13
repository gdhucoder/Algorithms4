package geekbang.ALGO.u39;

/**
 * Created by HuGuodong on 2019/11/8.
 */
public class BagProblem {

  public static int maxWeight = Integer.MIN_VALUE;

  public static void f(int i, int cw, int[] items, int n, int w) {
    if (cw == w || i == n) {
      if (cw > maxWeight) { // update maxWeight
        maxWeight = cw;
        System.out.println(maxWeight);
      }
      return;
    }

    f(i + 1, cw, items, n, w);
    if (cw + items[i] <= w) {
      f(i + 1, cw + items[i], items, n, w);
    }
  }

  public static void main(String[] args) {
    int[] itmes = {2, 5, 9, 10};
    f(0, 0, itmes, itmes.length, 18);
    System.out.println(maxWeight);

  }
}
