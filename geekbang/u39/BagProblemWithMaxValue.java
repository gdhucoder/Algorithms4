package geekbang.u39;

/**
 * Created by HuGuodong on 2019/11/9.
 */
public class BagProblemWithMaxValue {

  public static int maxWeight = Integer.MIN_VALUE;
  public static int maxValue = Integer.MIN_VALUE;

  public static void f(int i, int cw, int cv, int[] items, int n, int[] values, int w) {
    if (cw == w || i == n) {
      if (cw > maxWeight && cv > maxValue) { // update maxWeight
        maxWeight = cw;
        maxValue = cv;
//        System.out.println(maxWeight);
      }
      return;
    }

    f(i + 1, cw, cv, items, n, values, w);
    if (cw + items[i] <= w) {
      f(i + 1, cw + items[i], cv + values[i], items, n, values, w);
    }
  }

  public static void main(String[] args) {
    int[] itmes = {2, 10, 9, 10};
    int[] values = {100, 20, 1, 2};
    f(0, 0, 0, itmes, itmes.length, values, 18);
    System.out.println(maxWeight);
    System.out.println(maxValue);

  }
}
