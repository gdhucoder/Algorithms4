package ALeetCode.comp.p167;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

//  An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
//
//  Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
//
// 
//
//  Example 1:
//
//  Input: low = 100, high = 300
//  Output: [123,234]
//  Example 2:
//
//  Input: low = 1000, high = 13000
//  Output: [1234,2345,3456,4567,5678,6789,12345]
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/sequential-digits
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  static class Solution {

    public List<Integer> sequentialDigits(int low, int high) {
      List<Integer> ans = new ArrayList<>();
      for (int i = 1; i <= 9; ++i) {
        for (int j = 1; j + i - 1 <= 9; ++j) {
          int x = 0;
          for (int k = 0; k < i; ++k) {
            x = x * 10 + (k + j);

          }
          System.out.println(x);
          if (low <= x && x <= high) {

            ans.add(x);
          }
        }
      }
      return ans;
    }

  }


  public static void main(String[] args) {
    Solution s = new Solution();
    s.sequentialDigits(2000, 99999);
    System.out.println();
  }
}
