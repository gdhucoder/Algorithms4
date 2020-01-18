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

public class _0052_NQueensIi_bit {

  public static void main(String[] args) {
    Solution solution = new _0052_NQueensIi_bit().new Solution();
    solution.totalNQueens(4);
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    int cnt = 0;
    int N = 0;

    public int totalNQueens(int n) {
      N = n;
      _dfs(0, 0, 0, 0);
      return cnt;
    }

    public void _dfs(int row, int col, int pie, int na) {
      System.out.printf("%4d, %4s, %4s, %4s\n", row,
          Integer.toBinaryString(col),
          Integer.toBinaryString(pie),
          Integer.toBinaryString(na));
      if (row >= N) {
        cnt++;
        return;
      }
      //          可以放的位置1111110101 & N 个 1：去掉前面没用的1
      int bits = (~(col | pie | na) & ((1 << N) - 1));
//      System.out.println(Integer.toBinaryString(bits));
      while (bits > 0) {
        int p = bits & -bits; // 取最后一个1，例如 110100，取100
//        System.out.println(Integer.toBinaryString(p));
        // row+1下一行，col｜p 放上1，左移动一位，右移动一位
        _dfs(row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
        bits &= bits - 1; // 去掉最后一个1，例如110100 -> 110
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}