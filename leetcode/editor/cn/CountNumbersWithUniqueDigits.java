//给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。 
//
// 示例: 
//
// 输入: 2
//输出: 91 
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
// 
// Related Topics 数学 动态规划 回溯算法


package leetcode.editor.cn;

import java.util.LinkedList;

public class CountNumbersWithUniqueDigits {

  public static void main(String[] args) {
    Solution solution = new CountNumbersWithUniqueDigits().new Solution();
    solution.countNumbersWithUniqueDigits(3);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int countNumbersWithUniqueDigits(int n) {
      helper(0, n, new LinkedList<>());
      System.out.println(cnt);
      return 0;
    }

    int cnt;

    private void helper(int pos, int n, LinkedList<Integer> path) {
      if (pos == n) {
        System.out.println(path);
        cnt++;
        return;
      }
      cnt++;
      for (int i = pos == 0 ? 1 : 0; i < 10; i++) {
        if (!path.contains(i)) {
          path.addLast(i);
          helper(pos + 1, n, path);
          path.removeLast();
        }
      }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}