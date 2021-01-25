package ALeetCode.comp.p225;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public int kthLargestValue(int[][] matrix, int k) {
      int m = matrix.length;
      int n = matrix[0].length;
      int[][] mat = new int[m][n];
      for (int i = 0; i < m; i++) {
        mat[i][0] = matrix[i][0];
      }

      for (int i = 0; i < m; i++) {
        for (int j = 1; j < n; j++) {
          mat[i][j] = mat[i][j - 1] ^ matrix[i][j];
        }
      }
      //      PrintUtil.show(mat);
      for (int i = 1; i < m; i++) {
        for (int j = 0; j < n; j++) {
          mat[i][j] = mat[i][j] ^ mat[i - 1][j];
        }
      }
      PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
      for (int[] row : mat) {
        for (int num : row) {
          queue.offer(num);
        }
      }
      List<Integer> res = new ArrayList<>();
      while (!queue.isEmpty()) {
        res.add(queue.poll());
      }
      //      PrintUtil.show(mat);
      return res.get(k - 1);
    }
  }

  public static void main(String[] args) {
    int[][] in = {{5, 2}, {1, 6}};
    System.out.println();
    Solution s = new Solution();
    s.kthLargestValue(in, 4);
    System.out.println(1 ^ 6);
    System.out.println(5 ^ 2);

  }
}
