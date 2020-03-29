package ALeetCode.comp.p182_1;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int numTeams(int[] a) {
      int n = a.length;
      int sum = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          for (int k = 0; k < n; k++) {
            if (i < j && j < k) {
              if ((a[i] > a[j] && a[j] > a[k]) || a[i] < a[j] && a[j] < a[k]) {
                sum++;
              }
            }
          }
        }
      }
      return sum;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
