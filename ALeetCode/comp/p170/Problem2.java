package ALeetCode.comp.p170;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
      if (arr.length == 0 || queries.length == 0) {
        return new int[]{};
      }
      int[] res = new int[queries.length];
      for (int i = 0; i < queries.length; i++) {
        res[i] = calcXOR(arr, queries[i][0], queries[i][1]);
      }
      return res;
    }

    private int calcXOR(int[] arr, int left, int right) {
      int res = arr[left];
      for (int i = left + 1; i <= right; i++) {
        res |= arr[i];
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
