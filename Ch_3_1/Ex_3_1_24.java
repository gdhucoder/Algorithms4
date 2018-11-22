package Ch_3_1;

import static tools.ArrayGenerator.ascInts;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/21.
 */

public class Ex_3_1_24 {
  private static int compareTimes;

  public static int interpolationSearch(int[] a, int k){

    int lo = 0, hi = a.length -1 ;
    while (lo<=hi && k >= a[lo] && k <= a[hi]){
      int mid = lo + (hi-lo) * (k-a[lo])/(a[hi]-a[lo]);
      int cmp = compare(k, a[mid]);
      if (cmp == 0) {
        return mid;
      } else if (cmp < 0) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return -1;
  }
  public static int binarySearch(int[] a, int k){
    return 0;
  }
  private static int compare(int a, int b) {
    compareTimes++;
    return a - b;
  }

  public static void main(String[] args) {
    int N = 1024;
    int[] a = ascInts(0, N - 1);
    int index = interpolationSearch(a, 0);
    int n = Integer.toBinaryString(N).length();
    StdOut.println("N:" + Integer.toBinaryString(N));
    StdOut.printf("b: %d, compares :%d, N: %d", index, compareTimes, n);
  }





}
