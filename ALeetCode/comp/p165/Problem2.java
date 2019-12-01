package ALeetCode.comp.p165;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 12/1/19.
 */
public class Problem2 {

  static class Solution {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
      final int t = tomatoSlices;
      final int c = cheeseSlices;
      List<Integer> ans = new ArrayList<>();
      // corner 1
      if (tomatoSlices % 2 == 1) {
        return ans;
      }
      // corner 2
      if (t < 2 * c) {
        return ans;
      }

      if (t == 0 && c == 0) {
        ans.add(0);
        ans.add(0);
        return ans;
      }

      int totalJb = 0;
      while (totalJb < t) {
        int num_of_jb = totalJb / 4;
        int num_of_sm = (t - totalJb) / 2;
//        System.out.println(c);
//        System.out.printf("%d,%d\n", num_of_jb, num_of_sm);
        if (c == num_of_sm + num_of_jb) {
          ans.add(num_of_jb);
          ans.add(num_of_sm);
          return ans;
        }
        totalJb += 4;
//        System.out.println(totalJb);
      }
      return ans;

    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.numOfBurgers(16, 7));
  }
}
