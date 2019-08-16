package Ch_1_4;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_4_10 {

  public static int bsearch(int[] a, int key) {
    int lo = 0, hi = a.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) {
        hi = mid - 1;
      } else if (key > a[mid]) {
        lo = mid + 1;
      } else if (mid == 0 || a[mid - 1] != key) {
        return mid;
      } else {
        hi = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 1, 1, 2, 2, 2, 2, 3, 4, 4};
    StdOut.printf("index :%d\n", bsearch(a, 1)); // 0
    StdOut.printf("index :%d\n", bsearch(a, 2)); // 4
  }
}
