package ALeetCode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/relative-sort-array/ 37% not good enough Created by HuGuodong on
 * 11/26/19.
 */
public class P1122_Relative_Sort_Array {

  static class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
      Map<Integer, List<Integer>> map = new LinkedHashMap<>(arr2.length);
      int[] a = arr1;
      int[] b = arr2;
      for (int i = 0; i < b.length; i++) {
        List<Integer> l = new ArrayList<>();
        map.put(b[i], l);
      }
      List<Integer> temp = new ArrayList<>();
      for (int i = 0; i < a.length; i++) {
        if (map.containsKey(a[i])) {
          map.get(a[i]).add(a[i]);
        } else {
          temp.add(a[i]);
        }
      }

      temp.sort((x, y) -> (x - y));
      List<Integer> temp2 = new ArrayList<>();

      map.values().forEach(x -> temp2.addAll(x));
      temp2.addAll(temp);

      for (int i = 0; i < a.length; i++) {
        a[i] = temp2.get(i);
      }

      // PrintUtil.show(a);

      return a;
    }

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {2, 2, 1, 2};
    int[] b = {2};
    s.relativeSortArray(a, b);
  }
}
