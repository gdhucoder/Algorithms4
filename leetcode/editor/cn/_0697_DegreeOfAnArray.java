//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 
// 👍 224 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class

_0697_DegreeOfAnArray {

  public static void main(String[] args) {
    Solution solution = new _0697_DegreeOfAnArray().new Solution();
    int[] nums = {1, 2, 2, 3, 1, 4, 2};
    System.out.println(solution.findShortestSubArray(nums));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int findShortestSubArray(int[] nums) {
      Map<Integer, int[]> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int n = nums[i];
        if (!map.containsKey(n)) {
          map.put(n, new int[3]);
        }
        int[] cnts = map.get(n);
        cnts[0] += 1;
        if (cnts[0] == 1) {
          cnts[1] = i;
        }
        if (cnts[0] >= 2) {
          cnts[2] = i - cnts[1] + 1;
        }
        map.put(n, cnts);
      }

      PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> {
        int sub = map.get(b)[0] - map.get(a)[0];
        if (sub == 0) {
          return map.get(a)[2] - map.get(b)[2];
        }
        return sub;
      });
      for (Entry<Integer, int[]> entry : map.entrySet()) {
        int num = entry.getKey();
        que.offer(num);
      }

      return map.get(que.poll())[2];
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}