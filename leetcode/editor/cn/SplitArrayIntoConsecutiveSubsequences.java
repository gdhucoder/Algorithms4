//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 示例 2： 
//
// 
//输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 示例 3： 
//
// 
//输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10000 
// 
// Related Topics 堆 贪心算法 
// 👍 269 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SplitArrayIntoConsecutiveSubsequences {

  public static void main(String[] args) {
    Solution solution = new SplitArrayIntoConsecutiveSubsequences().new Solution();
    int[] inputs = new int[]{1, 2, 3, 3, 4, 4, 5, 5};
    solution.isPossible(inputs);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public boolean isPossible(int[] nums) {
      Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
      for (int x : nums) {
        if (!map.containsKey(x)) {
          map.put(x, new PriorityQueue<>());
        }
        if (map.containsKey(x - 1)) {
          int preLength = map.get(x - 1).poll();
          if (map.get(x - 1).isEmpty()) {
            map.remove(x - 1);
          }
          map.get(x).offer(preLength + 1);
        }
        else {
          map.get(x).offer(1);
        }
      }

      for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
        PriorityQueue<Integer> queue = entry.getValue();
        if (queue.peek() < 3) {
          return false;
        }
      }
      return true;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}