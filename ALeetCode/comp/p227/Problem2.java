package ALeetCode.comp.p227;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    static int res;

    public int maximumScore(int a, int b, int c) {
      res = 0;
      int[] arr = {a, b, c};
      Arrays.sort(arr);
      f(arr);
      return res;
    }


    private static void f(int[] a) {
      if (a[0] + a[1] <= a[2]) {
        res += a[0] + a[1];
        return;
      }
      if (a[0] == 0) {
        res += a[1];
        return;
      }
      a[0] -= 1;
      a[1] -= 1;
      res += 1;
      f(a);
    }


  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.maximumScore(2, 4, 6));
    System.out.println(s.maximumScore(4, 4, 6));
    System.out.println(s.maximumScore(1, 8, 8));
    System.out.println(s.maximumScore(4, 4, 7));
  }
}
