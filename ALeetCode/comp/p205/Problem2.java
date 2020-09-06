package ALeetCode.comp.p205;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int numTriplets(int[] nums1, int[] nums2) {
      int sum1 = total(nums1, nums2);
      if (isSame(nums1, nums2)) {
        return 2 * sum1;
      }
      int sum2 = total(nums2, nums1);
      return sum1 + sum2;
    }

    private boolean isSame(int[] a, int[] b) {
      if (a.length != b.length) return false;
      Arrays.sort(a);
      Arrays.sort(b);

      for (int i = 0; i < a.length; i++) {
        if (a[i] != b[i]) {
          return false;
        }
      }
      return true;
    }

    private int total(int[] a, int[] b) {
      int sum = 0;
      Map<Long, Integer> map = new HashMap<>();
      for (int i = 1; i < b.length; i++) {
        for (int j = 0; j < i; j++) {
          long total = (long) b[i] * (long) b[j];
          map.put(total, map.getOrDefault(total, 0) + 1);
        }
      }
      for (int i = 0; i < a.length; i++) {
        long total = (long) a[i] * (long) a[i];
        if (map.containsKey(total)) {
          sum += map.get(total);
        }
      }
      return sum;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(43024 * 99908);
    System.out.println(1864 * 1864);
    System.out.println();
  }
}
