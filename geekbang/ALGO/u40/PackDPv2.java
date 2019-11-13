package geekbang.ALGO.u40;

/**
 * Created by HuGuodong on 2019-10-27.
 */
public class PackDPv2 {

  /**
   * DP: save more space ( space: w )
   *
   * @param p
   * @return
   */
  public static int knapack(PackProblem p) {
    boolean[] states = new boolean[p.maxWeight + 1];
    states[0] = true;
    if (p.items[0] <= p.maxWeight) {
      states[p.items[0]] = true;
    }
    for (int i = 1; i < p.n; i++) {
//      for (int j = 0; j <= p.maxWeight - p.items[i]; j++) { // use updated value
      for (int j = p.maxWeight - p.items[i]; j >= 0; j--) { // use current value
        if (states[j])
          states[j + p.items[i]] = true;
      }
    }
    for (int i = p.maxWeight; i >= 0; i--) {
      if (states[i])
        return i;
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] weight = {2, 2, 4, 6, 3};
    PackProblem p = new PackProblem(weight, 9);
    System.out.printf("weight is %2d%n", knapack(p));
  }
}
