package ALeetCode.comp.p192;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int[] getStrongest(int[] a, int k) {
      Arrays.sort(a);
      int mid = median(a);
      Integer[] arr = convertToInteger(a);
      Arrays.sort(arr, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          //     |arr[i] - m| > |arr[j] - m|
          //        |arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]
          int diff = Math.abs(o1 - mid) - Math.abs(o2 - mid);
          if (diff == 0) {
            diff = o1 - o2;
          }
          return -diff;
        }
      });
      //      PrintUtil.show(arr);
      int[] res = new int[k];
      for (int i = 0; i < k; i++) {
        res[i] = arr[i];
      }
      return res;
    }

    private Integer[] convertToInteger(int[] a) {
      Integer[] res = new Integer[a.length];
      for (int i = 0; i < a.length; i++) {
        res[i] = a[i];
      }
      return res;
    }

    //     |arr[i] - m| > |arr[j] - m|
    //        |arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]

    private int median(int[] a) {
      int n = a.length;
      return a[(n - 1) / 2];
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {6, -3, 7, 2, 11};
    s.getStrongest(a, 2);
    System.out.println();
  }
}
