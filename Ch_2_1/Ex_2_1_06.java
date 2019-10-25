package Ch_2_1;

import Ch_1_4._Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import tools.ArrayGenerator;

/**
 * Created by HuGuodong on 2019-09-01.
 */
public class Ex_2_1_06 {

  public static double time(String alg, int size, int N) {
    Integer[] a = ArrayGenerator.fixedValueIntArray(1, size);
    _Stopwatch time = new _Stopwatch();
    for (int i = 0; i < N; i++) {
      if (alg.equals("select")) {
        _SelectionSort.sort(a);
      } else if (alg.equals("insertion")) {
        _InsertionSort.sort(a);
      }
    }
    return time.elapsedTime();
  }

  public static void main(String[] args) {
    int arraySize = 1000;
    int N = 1000;
    double timeSelect = time("select", arraySize, N);
    double timeInsertion = time("insertion", arraySize, N);
    StdOut.printf("selection sort uses: %.3fs\n", timeSelect);
    StdOut.printf("insertion sort uses: %.3fs\n", timeInsertion);
    StdOut.printf(
        "arraySize is %2d, run %2d times, selection sort use %.3f times than insertion sort\n",
        arraySize, N, timeSelect / timeInsertion);
//    selection sort uses: 0.420s
//    insertion sort uses: 0.009s
//    arraySize is 1000, run 1000 times, selection sort use 46.667 times than insertion sort
  }
}
