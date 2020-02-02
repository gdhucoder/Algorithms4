package ALeetCode.comp.p174;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2_v2 {

  static class Solution {

    public int minSetSize(int[] arr) {
      int[] f = new int[100001];
      for (int v : arr) {
        f[v]++;
      }
      Arrays.sort(f);
      int n = arr.length;
      int ret = 0;
      int count = 0;
      for (int i = f.length - 1; i >= 0; i--) {
        count += f[i];
        ret++;
        if (count >= n / 2)
          break;
      }
      return ret;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {7, 7, 7, 7, 7, 7};
    System.out.println(s.minSetSize(a));
  }
}
