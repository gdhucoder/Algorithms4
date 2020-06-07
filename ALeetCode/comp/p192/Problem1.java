package ALeetCode.comp.p192;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int[] shuffle(int[] a, int n) {
      int[] temp = new int[a.length];
      for (int i = 0; i < 2 * n; i += 2) {
        //        System.out.println(a[i/2]+":"+a[i/2+n]);
        temp[i] = a[i / 2];
        temp[i + 1] = a[i / 2 + n];
        System.out.println(i);
      }
      //      PrintUtil.show(temp);
      return temp;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {2, 5, 1, 3, 4, 7};
    int n = 3;
    s.shuffle(a, 3);
    System.out.println();
  }
}
