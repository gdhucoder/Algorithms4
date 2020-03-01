//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {

  public static void main(String[] args) {
    Solution solution = new WalkingRobotSimulation().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int robotSim(int[] cmds, int[][] obstacles) {
      // (0,1) (1,0) (0,-1) (-1,0)
      int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      int x = 0, y = 0, d = 0, max = 0;
      Set<String> set = new HashSet<>();
      for (int[] o : obstacles) set.add(o[0] + "," + o[1]);
      for (int c : cmds) {
        if (c == -1) d = (d + 1) % 4;
        else if (c == -2) d = (d + 3) % 4;
        else {
          while (c-- > 0 && !set.contains(x + dirs[d][0] + "," + y + dirs[d][1])) {
            x += dirs[d][0];
            y += y + dirs[d][1];
            max = Math.max(x * x + y * y, max);
          }
        }
      }
      return max;

    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}