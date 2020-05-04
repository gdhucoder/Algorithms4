package ALeetCode.comp.p187;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public boolean kLengthApart(int[] a, int k) {
      for (int i = 0; i < a.length; ) {
        if (a[i] == 0) {
          int temp = i;
          int cnt = 0;
          while (temp < a.length && a[temp] == 0) {
            temp++;
            cnt++;

          }
          if (cnt < k) return false;
          i = temp;
        }
        else {
          i++;
        }
      }

      return true;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //    ：nums = [1,0,0,0,1,0,0,1], k = 2
    int[] a = {1, 0, 0, 0, 1, 0, 0, 1};
    boolean res = s.kLengthApart(a, 2);
    System.out.println(res);

  }
}
