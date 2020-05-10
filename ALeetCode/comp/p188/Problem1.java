package ALeetCode.comp.p188;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public List<String> buildArray(int[] target, int n) {
      List<String> res = new ArrayList<>();
      for (int i = 1, j = 0; i <= n && j < target.length; i++) {
        if (target[j] == i) {
          res.add("Push");
          j++;
        }
        else {
          res.add("Push");
          res.add("Pop");
        }
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {2, 3, 4};
    int n = 4;
    System.out.println(s.buildArray(a, n));
  }
}
