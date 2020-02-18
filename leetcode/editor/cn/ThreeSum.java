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

import java.util.Arrays;
import java.util.LinkedList;
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
      List<List<Integer>> res = new LinkedList<>(); // 不需要动态扩容，速度更快
      for (int i = 0; i < num.length - 2; i++) {
        if (num[i] > 0) break;
        if (i > 0 && num[i] == num[i - 1]) continue;
        int lo = i + 1, hi = num.length - 1, sum = -num[i];
        while (lo < hi) {
          if (sum == num[lo] + num[hi]) {
            res.add(Arrays.asList(num[i], num[lo], num[hi]));
            while (lo < hi && num[lo] == num[lo + 1]) lo++;
            while (lo < hi && num[hi] == num[hi - 1]) hi--;
            lo++;
            hi--;
          }
          else if (sum > num[lo] + num[hi]) lo++;
          else hi--;
        }
      }
      return res;
    }


  }
  //leetcode submit region end(Prohibit modification and deletion)

}