package ALeetCode.interview.t01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by HuGuodong on 2020/6/4.
 */
public class ProblemHW01 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      int n = scanner.nextInt();
      int k = scanner.nextInt();
      printGetK(n, k);
    }
  }

  /**
   * print Kth list in the res list.
   *
   * @param n
   * @param k
   */
  public static void printGetK(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used = new boolean[n + 1];
    helper(n, new ArrayList<>(), used, res);
    List<Integer> kth = res.get(k);
    for (Integer num : kth) {
      System.out.print(num);
    }
  }

  /**
   * helper function, generates combo list.
   *
   * @param n
   * @param combo
   * @param used
   * @param res
   */
  private static void helper(int n, List<Integer> combo, boolean[] used, List<List<Integer>> res) {
    if (combo.size() == n) {
      res.add(new ArrayList<>(combo));
      return;
    }
    for (int i = 1; i <= n; i++) {
      if (!used[i]) {
        used[i] = true;
        combo.add(i);
        helper(n, combo, used, res);
        combo.remove(combo.size() - 1);
        used[i] = false;
      }

    }
  }
}
