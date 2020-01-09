//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 回溯算法

package leetcode.editor.cn;

public class _0052_NQueensIi {

  public static void main(String[] args) {
    Solution solution = new _0052_NQueensIi().new Solution();
    System.out.println(Integer.toBinaryString((1 << 4) - 1));
    System.out.println(Integer.toBinaryString((1 << 4)));
    int ans = (Integer.parseInt("0100", 2)
        | Integer.parseInt("1000", 2)
        | Integer.parseInt("0001", 2));
    System.out.println(Integer.toBinaryString(~ans));

  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int totalNQueens(int n) {
      return 0;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}