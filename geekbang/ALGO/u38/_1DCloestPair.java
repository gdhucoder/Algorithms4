package geekbang.ALGO.u38;

import tools._Math;

/**
 * Created by HuGuodong on 2019/11/7.
 */
public class _1DCloestPair {


  public static void find(int[] a) {
    int mindist = mindist(a, 0, a.length - 1);
    System.out.println(mindist);
  }

  /**
   * 求一维最近点对 假设数组已经有序 思想是：分治思想 1、将数组平分两份 2、分别求 左数组 和 右数组 的最短距离 3、再求左数组下标最大和右数组下标最小的这两个点的距离
   * 4、取这个三个值的最小值 5、左数组右数组元素只剩两个时 mindist = a[hi]-a[lo]
   *
   * @param a
   * @param lo
   * @param hi
   * @return
   */
  public static int mindist(int[] a, int lo, int hi) {
    if (lo >= hi) {
      return Integer.MAX_VALUE;
    } else if (lo == hi - 1) {
      return a[hi] - a[lo];
    } else {
      int m = lo + (hi - lo) / 2;
      int delta_1 = mindist(a, lo, m); // left points set
      int delta_2 = mindist(a, m + 1, hi); // right points set
      int delta_3 = a[m + 1] - a[m]; // strip points min distance
      return _Math.min(delta_1, delta_2, delta_3);
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 4, 10, 20, 100};
    find(a);//1
  }

}
