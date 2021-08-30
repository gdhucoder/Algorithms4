package ALeetCode.comp.p256;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public String kthLargestNumber(String[] nums, int k) {
      Arrays.sort(nums, new CompareStringnum());
      return nums[k - 1];
    }

    class CompareStringnum implements Comparator<String> {

      @Override
      public int compare(String s1, String s2) {
        if (s1.equals(s2)) {
          return 0;
        }
        else if (s1.length() != s2.length()) {
          return s1.length() - s2.length();
        }
        else {
          int len = s1.length();
          for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
              return s1.charAt(i) - s2.charAt(i);
            }
          }
        }
        return 0;
      }
    }


  }

  public static void main(String[] args) {
    Solution s = new Solution();
    var arr = new String[]{"2", "21", "12", "1"};
    var res = s.kthLargestNumber(arr, 3);
    System.out.println(res);
  }
}
