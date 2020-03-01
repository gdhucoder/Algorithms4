package ALeetCode.comp.p179;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int[] smallerNumbersThanCurrent(int[] a) {
      if (a.length == 0) return new int[]{};
      int[] res = new int[a.length];
      for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a.length; j++) {
          if (a[j] < a[i] && i != j) {
            res[i]++;
          }
        }
      }
      //      PrintUtil.show(res);
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = new int[]{7, 7};
    System.out.println(s.smallerNumbersThanCurrent(a));
  }
}
