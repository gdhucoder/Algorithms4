package ALeetCode.comp.p235;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem4 {

  static class Solution {

    public static final int MOD = 1000000000 + 7;
    int maxIndx = 0;
    int j = 0;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
      if (arrEquals(nums1, nums2)) return 0;

      int n = nums1.length;
      int[] abs = new int[n];
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        abs[i] = Math.abs(nums1[i] - nums2[i]);
        if (abs[i] > max) {
          this.maxIndx = i;
        }
      }
      int decre = 0;
      for (int i = 0; i < n; i++) {
        decre = Math.min(nums1[i] - nums2[maxIndx] - abs[maxIndx], decre);
      }
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum = (sum + abs[i]) % MOD;
      }
      sum += decre;
      return sum;
    }
  }

  private static boolean arrEquals(int[] num1, int[] num2) {
    for (int i = 0; i < num1.length; i++) {
      if (num1[i] != num2[i]) return false;
    }
    return true;
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    System.out.println();
  }
}
