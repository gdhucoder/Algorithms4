//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  // solution 1 排序+双指针
  public static void main(String[] args) {
    Solution solution = new ThreeSum().new Solution();
    int[] a = {-1, -1, 0, 0, 1, 1};
    System.out.println(solution.threeSum(a));
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<List<Integer>> threeSum(int[] num) {
      Arrays.sort(num);
      List<List<Integer>> res = new ArrayList<>();

      for (int i = 0; i < num.length; i++) {
        if (num[i] > 0) { // improve
          break;
        }
        if (i > 0 && num[i] == num[i - 1]) {
          continue;
        }
        int L = i + 1;
        int R = num.length - 1;

        while (L < R) {
          if (num[i] + num[L] + num[R] == 0) {
            res.add(Arrays.asList(num[i], num[L], num[R]));
            while (L < R && num[L] == num[L + 1]) // remove duplicates
              L++;
            while (L < R && num[R] == num[R - 1]) // remove duplicates
              R--;
            L++;
            R--;
          } else if (num[i] + num[L] + num[R] < 0) {
            L++;
          } else {
            R--;
          }
        }
      }
      return res;
    }


  }
//leetcode submit region end(Prohibit modification and deletion)

}