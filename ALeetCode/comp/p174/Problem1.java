package ALeetCode.comp.p174;

import java.util.Comparator;
import java.util.PriorityQueue;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Pair {

    int[] a;
    int index;

    public Pair(int[] a, int index) {
      this.a = a;
      this.index = index;
    }
  }

  static class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
      //
      if (mat.length == 0) {
        return new int[]{};
      }

      PriorityQueue<Pair> queue = new PriorityQueue<>(k, new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {

          for (int i = 0; i < o1.a.length; i++) {
            if (o1.a[i] == o2.a[i]) {
              continue;
            } else {
              return o1.a[i] - o2.a[i];
            }
          }
          return o1.index - o2.index;
        }
      });

      for (int i = 0; i < mat.length; i++) {
        queue.add(new Pair(mat[i], i));
      }
      int[] result = new int[k];

      int i = 0;
      while (!queue.isEmpty() && i < k) {
        result[i++] = queue.poll().index;
      }

      PrintUtil.show(result);
      return result;

      //

    }
  }

  public static void main(String[] args) {
    String arrayStr = "[[1,1,0,0,0],[1,1,1,1,0],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,1]]".
        replace('[', '{').replace(']', '}');
    int k = 3;
    int[][] a = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0},
        {1, 1, 1, 1, 1}};
    System.out.println(arrayStr);
    Solution s = new Solution();
    System.out.println(s.kWeakestRows(a, k));
  }
}
