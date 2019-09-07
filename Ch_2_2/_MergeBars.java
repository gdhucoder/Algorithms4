package Ch_2_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/******************************************************************************
 *  Compilation:  javac MergeBars.java
 *  Execution:    java MergeBars m n
 *  Dependencies: StdDraw.java
 *
 *  Sort n random real numbers between 0 and 1 (with m disintct values)
 *  using mergesort with cutoff to insertion sort.
 *
 *  Visualize the results by ploting bars with heights proportional
 *  to the values.
 *
 *  % java MergeBars 1000 96
 *
 *  Comments
 *  --------
 *   - suggest removing the 10% default StdDraw border
 *   - if image is too large, it may not display properly but you can
 *     still save it to a file
 *
 ******************************************************************************/


public class _MergeBars {

  private static final int VERTICAL = 70;
  private static final int CUTOFF = 12;

  private static int numberOfRows;
  private static int row = 0;


  // stably merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]
  public static void merge(double[] a, double[] aux, int lo, int mid, int hi) {

    // copy to aux[]
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    // merge back to a[]
    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid)
        a[k] = aux[j++];
      else if (j > hi)
        a[k] = aux[i++];
      else if (less(aux[j], aux[i]))
        a[k] = aux[j++];
      else
        a[k] = aux[i++];
    }
  }

  // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
  private static void sort(double[] a, double[] aux, int lo, int hi) {
    int n = hi - lo + 1;
    if (n <= CUTOFF) {
      insertionSort(a, lo, hi);
      show(a, lo, hi);
      return;
    }
    if (hi <= lo)
      return;
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
    show(a, lo, hi);
  }

  public static void sort(double[] a) {
    double[] aux = new double[a.length];
    sort(a, aux, 0, a.length - 1);
  }

  // sort from a[lo] to a[hi] using insertion sort
  private static void insertionSort(double[] a, int lo, int hi) {
    for (int i = lo; i <= hi; i++)
      for (int j = i; j > lo && less(a[j], a[j - 1]); j--)
        exch(a, j, j - 1);
  }

  private static boolean less(double v, double w) {
    return v < w;
  }

  private static void exch(double[] a, int i, int j) {
    double t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  // draw one row of trace
  private static void show(double[] a, int lo, int hi) {
    double y = numberOfRows - row - 1;
    for (int k = 0; k < a.length; k++) {
      if (k < lo)
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
      else if (k > hi)
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
      else
        StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.filledRectangle(k, y + a[k] * 0.25, 0.25, a[k] * 0.25);
    }
    row++;
  }

  public static void main(String[] args) {
    int m = Integer.parseInt(args[0]);
    int n = Integer.parseInt(args[1]);
    if (args.length == 3) {
      long seed = Long.parseLong(args[2]);
      StdRandom.setSeed(seed);
    }
    double[] a = new double[n];
    double[] b = new double[n];
    for (int i = 0; i < n; i++) {
      a[i] = (1 + StdRandom.uniform(m)) / (double) m;
      b[i] = a[i];
    }

    StdDraw.enableDoubleBuffering();

    // precompute the number of rows
    numberOfRows = 0;
    sort(b);
    numberOfRows = row;
    row = 0;
    StdDraw.clear();

    StdDraw.setCanvasSize(800, numberOfRows * VERTICAL);
    StdDraw.show();
    StdDraw.square(0.5, 0.5, 0.5);
    StdDraw.setXscale(-1, n);
    StdDraw.setYscale(-0.5, numberOfRows);
    StdDraw.show();
    sort(a);
    StdDraw.show();
  }
}
