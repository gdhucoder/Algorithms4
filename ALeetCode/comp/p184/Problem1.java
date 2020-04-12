package ALeetCode.comp.p184;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public List<String> stringMatching(String[] a) {
      List<String> res = new ArrayList<>();
      for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a.length; j++) {
          if (i != j && a[i].length() > a[j].length() && a[i].contains(a[j])) {
            if (!res.contains(a[j])) res.add(a[j]);
          }
        }
      }
      return res;
    }

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String[] words = {"leetcoder", "leetcode", "od", "hamlet", "am"};
    System.out.println(s.stringMatching(words));
  }
}
