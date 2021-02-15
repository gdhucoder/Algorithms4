package ALeetCode.comp.p228;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public int minimumSize(int[] nums, int maxOperations) {
      Arrays.sort(nums);
      int ans = 0;
      int lo = 1, hi = nums[nums.length - 1];
      while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (check(nums, mid) <= maxOperations) {
          ans = mid;
          hi = mid - 1;
        }
        else {
          lo = mid + 1;
        }
      }
      return ans;
    }

    long check(int[] a, int h) {
      long res = 0;
      for (int v : a) {
        res += (v - 1) / h;
      }
      return res;
    }

  }

  public static void main(String[] args) {
    System.out.println();
    int[] arr = {2, 2, 4, 8};
    Solution s = new Solution();

    System.out.println(s.minimumSize(arr, 4));
  }
}
