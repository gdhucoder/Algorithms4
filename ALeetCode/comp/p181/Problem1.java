package ALeetCode.comp.p181;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  class Solution {

    class Pair {

      int i;
      int j;

      Pair(int i, int j) {
        this.i = i;
        this.j = j;
      }

      @Override
      public boolean equals(Object obj) {
        Pair temp = (Pair) obj;
        return this.i == temp.i && this.j == temp.j;
      }

      @Override
      public int hashCode() {
        return i << 10 + j;
      }
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
      List<Integer> res = new ArrayList<>();
      if (matrix.length == 0) return res;
      Set<Pair> max = new HashSet<>();
      Set<Pair> min = new HashSet<>();
      for (int i = 0; i < matrix.length; i++) {
        int minIdx = minIdx(matrix[i]);
        min.add(new Pair(i, minIdx));
      }
      for (int i = 0; i < matrix[0].length; i++) {
        int maxIdx = maxIdx(matrix, i);
        Pair p = new Pair(maxIdx, i);
        max.add(p);
        if (min.contains(p)) {
          res.add(matrix[p.i][p.j]);
        }
      }
      return res;
    }

    private int minIdx(int[] a) {
      int min = 0;
      for (int i = 1; i < a.length; i++) {
        if (a[min] > a[i]) {
          min = i;
        }
      }
      return min;
    }

    private int maxIdx(int[][] a, int col) {
      int max = 0;
      for (int i = 1; i < a.length; i++) {
        if (a[max][col] < a[i][col]) {
          max = i;
        }
      }
      return max;
    }
  }

  public static void main(String[] args) {
    Solution s = new Problem1().new Solution();
    //    int[][] a = [[3,7,8],[9,11,13],[15,16,17]]
    int[][] a = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
    System.out.println(s.luckyNumbers(a));
  }
}
