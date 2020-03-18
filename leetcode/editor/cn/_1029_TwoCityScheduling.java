//公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。 
//
// 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。 
//
// 
//
// 示例： 
//
// 输入：[[10,20],[30,200],[400,50],[30,20]]
//输出：110
//解释：
//第一个人去 A 市，费用为 10。
//第二个人去 A 市，费用为 30。
//第三个人去 B 市，费用为 50。
//第四个人去 B 市，费用为 20。
//
//最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= costs.length <= 100 
// costs.length 为偶数 
// 1 <= costs[i][0], costs[i][1] <= 1000 
// 
// Related Topics 贪心算法


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class _1029_TwoCityScheduling {

  public static void main(String[] args) {
    Solution solution = new _1029_TwoCityScheduling().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int twoCitySchedCost(int[][] costs) {
      if (costs.length == 0) return 0;
      Arrays.sort(costs, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          return (o1[1] - o1[0]) - (o2[1] - o2[0]);
        }
      });
      int total = 0;
      for (int i = 0; i < costs.length / 2; i++) {
        total += costs[i][0] + costs[i + costs.length / 2][1];
      }
      return total;
    }

  }
  //leetcode submit region end(Prohibit modification and deletion)

}