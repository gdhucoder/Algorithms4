package ALeetCode.comp.p174;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int minSetSize(int[] arr) {
      if (arr.length <= 1)
        return 1;
      Map<Integer, Integer> dict = new HashMap<>();
      for (int i = 0; i < arr.length; i++) {
        int ele = arr[i];
        if (dict.get(ele) == null) {
          dict.put(ele, 1);
        } else {
          dict.put(ele, dict.get(ele) + 1);
        }
      }

      Integer[] temp = dict.values().toArray(new Integer[0]);
      Arrays.sort(temp, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return o2 - o1;
        }
      });
      int result = 0;
      int count = 0;
      for (int i = 0; i < temp.length && count < arr.length / 2; i++) {
        if (count >= arr.length / 2) {
          return result;
        }
        count += temp[i];
        result++;
      }
      return result;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {7, 7, 7, 7, 7, 7};
    System.out.println(s.minSetSize(a));
  }
}
