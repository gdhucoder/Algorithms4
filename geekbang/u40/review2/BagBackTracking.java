package geekbang.u40.review2;

/**
 * 复习一波！ Created by HuGuodong on 2019/11/12.
 */
public class BagBackTracking {

  int maxW = Integer.MIN_VALUE;
  int n = 5;
  int w = 10;
  int[] items;

  BagBackTracking(int[] items) {
    this.items = items;
  }


  boolean[][] mem = new boolean[n][w];

  public void f(int i, int cw) {
    if (i == n || cw == w) {
      if (cw > maxW)
        maxW = cw;
      return;
    }
    if (mem[i][cw]) {
      return;
    }
    mem[i][cw] = true;
    f(i + 1, cw);
    if (cw + items[i] <= w) {
      f(i + 1, cw + items[i]);
    }
  }


  public static void main(String[] args) {
    int[] items = {2, 2, 4, 6, 3};
    BagBackTracking p = new BagBackTracking(items);
    p.f(0, 0);
    System.out.println(p.maxW);
  }

}
