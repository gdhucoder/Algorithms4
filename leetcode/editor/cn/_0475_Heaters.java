//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。 
//
// 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。 
//
// 说明: 
//
// 
// 给出的房屋和供暖器的数目是非负数且不会超过 25000。 
// 给出的房屋和供暖器的位置均是非负数且不会超过10^9。 
// 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。 
// 所有供暖器都遵循你的半径标准，加热的半径也一样。 
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3],[2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4],[1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
// Related Topics 二分查找 
// 👍 153 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class _0475_Heaters {

  public static void main(String[] args) {
    Solution solution = new _0475_Heaters().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int findRadius(int[] houses, int[] heaters) {
      Arrays.sort(heaters);
      int result = 0;
      for (int house : houses) {
        int index = Arrays.binarySearch(heaters, house);
        if (index < 0) {
          index = ~index;
          int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
          int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
          result = Math.max(result, Math.min(dist1, dist2));
        }
      }
      return result;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}