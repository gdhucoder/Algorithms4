package geekbang.u40;

/**
 * Created by HuGuodong on 2019-10-26.
 */
public class PackProblem {

  final int[] items;
  final int maxWeight;
  final int n;
  int loadWeight;


  public PackProblem(int[] items, int maxWeight) {
    this.items = items;
    this.maxWeight = maxWeight;
    this.n = items.length;
    loadWeight = -1;
  }
}
