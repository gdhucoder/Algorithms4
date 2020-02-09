package ALeetCode.comp.p175;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public boolean checkIfExist(int[] arr) {
      if (arr.length == 0)
        return false;
      Arrays.sort(arr);
      for (int i = 0; i < arr.length; i++) {
        int pos = Arrays.binarySearch(arr, 2 * arr[i]);
        if (pos >= 0 && pos != i) {
          return true;
        }
      }
      return false;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {-10, 12, -20, -8, 15};
    System.out.println(s.checkIfExist(a));
  }
}
