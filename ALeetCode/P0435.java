package ALeetCode;

import java.util.Arrays;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-10-19.
 */
public class P0435 {

  public static int eraseOverlapIntervals(int[][] intervals) {

    return 0;
  }

  public static void qsort(int[][] a) {
    sort(a, 0, a.length - 1);
  }

  public static void sort(int[][] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  public static int partition(int[][] a, int lo, int hi) {
    int v = a[lo][1];
    int i = lo;
    int j = hi + 1;
    while (true) {
      while (a[++i][1] < v) {
        if (i == hi)
          break;
      }
      while (v < a[--j][1]) {
        if (j == lo)
          break;
      }
      if (i >= j) {
        break;
      }
      exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
  }

  public static void exch(int[][] a, int i, int j) {
    int[] temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }


  public static void main(String[] args) {
//    int[][] a = {{1, 5}, {2, 4}, {3, 5}, {5, 9}, {6, 8}, {8, 10}};
    int[][] a = {{1, 2}, {1, 2}};
    qsort(a);
    PrintUtil.show(a);
    for (int i = 0, j = 1; i < a.length && j < a.length; ) {
      if (a[j][0] < a[i][1]) {
        j++;
      } else {
        i = j;
        j++;
        PrintUtil.show(a[i]);
      }
    }
  }
}
