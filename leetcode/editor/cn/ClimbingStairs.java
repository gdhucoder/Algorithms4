//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

package leetcode.editor.cn;

public class ClimbingStairs {

  public static void main(String[] args) {
    Solution solution = new ClimbingStairs().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    int[] state;

    public int climbStairs(int n) {
      state = new int[n + 1];
      return _climb(n);
    }

    private int _climb(int i) {
      if (i == 1)
        return 1;
      if (i == 2)
        return 2;
      if (state[i] > 0)
        return state[i];
      int res = _climb(i - 1) + _climb(i - 2);
      state[i] = res;
      return res;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}