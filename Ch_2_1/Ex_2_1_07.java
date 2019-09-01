package Ch_2_1;

import Ch_1_4._Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import tools.ArrayGenerator;

/**
 * Created by HuGuodong on 2019-09-01.
 */
public class Ex_2_1_07 {

  public static double time(String alg, int size, int N) {
    double totalTime = 0.0;
    for (int i = 0; i < N; i++) {
      Integer[] a = ArrayGenerator.descIntArray(0, size);
      _Stopwatch time = new _Stopwatch();
      if (alg.equals("select")) {
        _SelectionSort.sort(a);
      } else if (alg.equals("insertion")) {
        _InsertionSort.sort(a);
      }
      totalTime += time.elapsedTime();
    }
    return totalTime;
  }

  public static void main(String[] args) {
    int arraySize = 1000;
    int N = 10000;
    double timeSelect = time("select", arraySize, N);
    double timeInsertion = time("insertion", arraySize, N);
    StdOut.printf("selection sort uses: %.3fs\n", timeSelect);
    StdOut.printf("insertion sort uses: %.3fs\n", timeInsertion);
    StdOut.printf(
        "arraySize is %2d, run %2d times, insertion sort use %.3f times than selection sort\n",
        arraySize, N, timeInsertion / timeSelect);

//    selection sort uses: 4.876s
//    insertion sort uses: 15.736s
//    arraySize is 1000, run 10000 times, insertion sort use 3.227 times than selection sort

  }
}
