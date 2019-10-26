package geekbang.u40;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-10-26.
 */
public class Pack02 {

  public static int solve(PackProblem p) {
    f(0, 0, p);
    return p.loadWeight;
  }

  public static void f(int i, int cw, PackProblem p) {
    if (i == p.n || cw == p.maxWeight) {
      if (cw >= p.loadWeight) {
        p.loadWeight = cw;
      }
      return;
    }
    f(i + 1, cw, p);
    if (cw + p.items[i] <= p.maxWeight) {
      f(i + 1, cw + p.items[i], p);
    }
  }

  public static void main(String[] args) {
    int[] a = {2, 3, 6, 8};
    PackProblem p = new PackProblem(a, 12);
    solve(p);
    System.out.printf("pack loaded weight: %3d, max weight: %3d%n", p.loadWeight, p.maxWeight);
  }
}
