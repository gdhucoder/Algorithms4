package ALeetCode.comp.p182;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    private Map<Integer, Integer> map = new HashMap<>();

    public int sumFourDivisors(int[] nums) {
      if (nums.length == 0) return 0;
      int res = 0;
      for (int n : nums) {
        if (map.containsKey(n)) {
          res += map.get(n);
        }
        else {
          int sumFour = isFour(n);
          map.put(n, sumFour);
          res += sumFour;
        }

      }
      return res;
    }

    private int isFour(int n) {
      int res = 1 + n;
      int cnt = 2;
      Set<Integer> set = new HashSet<>();
      for (int i = 2; i <= (int) Math.sqrt(n); i++) {
        if (set.contains(i)) continue;
        if (n % i == 0) {
          set.add(i);
          set.add(n / i);
          cnt += 2;
          res += i + n / i;
        }
        if (cnt > 4) {
          return 0;
        }
      }
      return set.size() == 2 ? res : 0;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    // 6: 1,2,3,6  12
    // 8: 1 8 2 4 15
    // 10: 1 10 2 5 18
    System.out.println(s.sumFourDivisors(nums));
  }
}
