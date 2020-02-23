package ALeetCode.comp.pd02;

import java.util.Arrays;
import java.util.Comparator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int[] sortByBits(int[] a) {
      if (a.length == 0) return null;
      Integer[] tmp = new Integer[a.length];
      for (int i = 0; i < a.length; i++) {
        tmp[i] = a[i];
      }

      Arrays.sort(tmp, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          int numOfO1 = numberOf1(o1), numOfO2 = numberOf1(o2);
          return numOfO1 == numOfO2 ? o1 - o2 : numOfO1 - numOfO2;
        }
      });
      for (int i = 0; i < a.length; i++) {
        a[i] = tmp[i];
      }
      return a;
    }

    public int numberOf1(int n) {
      int count = 0;
      while (n != 0) {
        n = n & (n - 1);
        count++;
      }
      return count;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    PrintUtil.show(s.sortByBits(a));
  }
}
