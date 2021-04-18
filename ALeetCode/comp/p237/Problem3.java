package ALeetCode.comp.p237;

import java.util.Arrays;
import java.util.PriorityQueue;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public int[] getOrder(int[][] tasks) {
      int n = tasks.length;
      int[][] pairs = new int[n][3];
      for (int i = 0; i < n; i++) {
        pairs[i] = new int[]{tasks[i][0], tasks[i][1], i};
      }
      // 根据下标和用时排序
      Arrays.sort(pairs, (t1, t2) -> t1[0] - t2[0] == 0 ? t1[1] - t2[1] : t1[0] - t2[0]);
      int arrIdx = 0;
      PriorityQueue<int[]> p = new PriorityQueue<>(
          (t1, t2) -> t1[1] - t2[1] == 0 ? t1[2] - t2[2] : t1[1] - t2[1]);
      p.offer(pairs[arrIdx++]);
      int[] res = new int[n];
      int resIdx = 0;
      long time = pairs[0][0];
      while (!p.isEmpty() && arrIdx < n) {
        int[] cur = p.poll();
        res[resIdx++] = cur[2];
        time = time + cur[1]; // 当前任务总用时
        while (arrIdx < n && pairs[arrIdx][0] <= time) {
          p.offer(pairs[arrIdx++]);
        }
      }
      while (arrIdx < n) {
        p.offer(pairs[arrIdx++]);
      }
      while (!p.isEmpty()) {
        res[resIdx++] = p.poll()[2];
      }
      PrintUtil.show(res);
      return res;

    }

  }

  public static void main(String[] args) {
    System.out.println();
    int[][] a = new int[][]{{100, 100}, {1000000000, 1000000000}};
    Solution s = new Solution();
    s.getOrder(a);
  }
}
