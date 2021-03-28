package ALeetCode.comp.p234;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int reinitializePermutation(int n) {
      int cnt = 0;
      int[] perm = new int[n];
      for (int i = 0; i < n; i++) {
        perm[i] = i;
      }
      int[] ori = new int[n];
      for (int i = 0; i < n; i++) {
        ori[i] = i;
      }
      while (true) {
        cnt++;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          if (i % 2 == 0) {
            arr[i] = perm[i / 2];
          }
          else {
            arr[i] = perm[n / 2 + (i - 1) / 2];
          }
        }

        if (checkEqual(ori, arr)) {
          return cnt;
        }
        assign(arr, perm);
      }

    }
  }

  private static void assign(int[] ori, int[] out) {
    for (int i = 0; i < ori.length; i++) {
      out[i] = ori[i];
    }
  }

  private static boolean checkEqual(int[] a1, int[] a2) {
    for (int i = 0; i < a1.length; i++) {
      if (a1[i] != a2[i]) return false;

    }
    return true;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
    for (int i = 0; i < 1002; i += 2) {
      int res = s.reinitializePermutation(i);
      System.out.println(i + ":" + res);
    }

  }
}
