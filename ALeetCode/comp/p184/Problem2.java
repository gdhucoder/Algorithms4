package ALeetCode.comp.p184;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int[] processQueries(int[] q, int m) {
      int[] P = new int[m];
      for (int i = 0; i < m; i++) {
        P[i] = i + 1;
      }
      int len = q.length;
      int[] res = new int[len];
      for (int i = 0; i < len; i++) {
        int pos = find(P, q[i]);
        res[i] = pos;
        swap(P, pos);
      }
      return res;
    }

    private void swap(int[] P, int pos) {
      int temp = P[pos];
      for (int i = pos; i >= 1; i--) {
        P[i] = P[i - 1];
      }
      P[0] = temp;
    }

    private int find(int[] P, int key) {
      for (int i = 0; i < P.length; i++) {
        if (P[i] == key) return i;
      }
      return 0;
    }
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {4, 1, 2, 2};
    int m = 4;
    s.processQueries(a, m);
    System.out.println();
  }
}
