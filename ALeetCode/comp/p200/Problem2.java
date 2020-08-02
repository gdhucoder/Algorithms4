package ALeetCode.comp.p200;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int getWinner(int[] a, int k) {
      if (k >= a.length - 1) return max(a);
      int max = a[0], cnt = 0;
      for (int i = 1; i < a.length; i++) {
        if (cnt == k) return max;
        if (a[i] > max) {
          max = a[i];
          cnt = 1;
        }
        else {
          cnt++;
        }

      }
      return max;
    }

    private int max(int[] a) {
      int res = Integer.MIN_VALUE;
      for (int n : a) {
        res = Math.max(n, res);
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
