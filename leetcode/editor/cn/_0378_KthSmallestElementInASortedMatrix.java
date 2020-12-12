//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例： 
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 
//
// 提示： 
//你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找 
// 👍 492 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _0378_KthSmallestElementInASortedMatrix {

  public static void main(String[] args) {
    Solution solution = new _0378_KthSmallestElementInASortedMatrix().new Solution();
    int[][] m = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
    System.out.println(solution.kthSmallest(m, 8));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int kthSmallest(int[][] matrix, int k) {
      PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
      for (int[] row : matrix) {
        for (int e : row) {
          heap.offer(e);
          if (heap.size() > k) {
            heap.poll();
          }
        }
      }

      System.out.println(new ArrayList<>(heap));
      while (!heap.isEmpty()) {
        System.out.println(heap.poll());
      }
      return 0;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}