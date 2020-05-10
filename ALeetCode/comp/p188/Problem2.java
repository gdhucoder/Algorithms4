package ALeetCode.comp.p188;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int countTriplets(int[] arr) {
      int a, b, res = 0;
      for (int i = 0; i < arr.length; i++) {
        a = arr[i];
        for (int j = i + 1; j < arr.length; j++) {
          a ^= arr[j];
          b = arr[j];
          for (int k = j; k < arr.length; k++) {
            b ^= arr[k];
            if (a == b) {
              res++;
            }
          }
        }
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr = {2, 3};
    System.out.println(s.countTriplets(arr));
  }
}
