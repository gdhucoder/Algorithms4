package Ch_1_1;

import static tools.ArrayGenerator.ascInts;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/4/10.
 */

public class Ex_1_1_22 {

  public static int rank(int[] arr, int key) {
    return rank(arr, key, 0, arr.length - 1, 0);
  }

  private static int rank(int[] arr, int key, int lo, int hi, int depth) {
//    printIndent(lo, hi, depth);
    if (lo > hi)
      return -1;
    int mid = lo + (hi - lo) / 2;
    if (arr[mid] < key)
      return rank(arr, key, mid + 1, hi, depth + 1);
    else if(arr[mid] > key)
      return rank(arr, key, lo, mid - 1, depth + 1);
    else
      return mid;
  }

  private static void printIndent(int lo, int hi, int depth) {
    for (int i = 0; i < depth; i++) {
      StdOut.print("-");
    }
    StdOut.printf("%2d %2d %2d",depth,  lo, hi);
    StdOut.println();
  }

  public static void main(String[] args) {
    int[] arr = ascInts(10);
    StdOut.println(Arrays.toString(arr));
    StdOut.println(rank(arr, 9));
  }
}
