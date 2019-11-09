package ALeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 2019/11/8.
 */
public class P0039 {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<Integer> l = new ArrayList<>();
    for (int i = 0; i < 1; i++) {
      isOK(0, 0, candidates, target, l);
    }

    return null;
  }


  private void isOK(int sum, int start, int[] a, int target, List<Integer> l) {

    if (sum + a[start] < target) {
      for (int i = start; i < a.length; i++) {
        for (int j = i; j < a.length; j++) {
          l.add(a[start]);
          isOK(sum + a[start], j, a, target, l);
        }
      }
    } else if (sum + a[start] == target) {
      l.add(a[start]);
      System.out.println(l);
      l.clear();
      return;
    } else {
      l.clear();
      return;
    }
  }

  public static void main(String[] args) {
    int[] a = {2, 3, 6, 7};
    P0039 p = new P0039();
    p.combinationSum(a, 7);
  }
}
