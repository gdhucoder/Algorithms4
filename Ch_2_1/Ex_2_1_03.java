package Ch_2_1;

import edu.princeton.cs.algs4.StdOut;
import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-08-29.
 */
public class Ex_2_1_03 extends _Example {

  // reverse order array
  // if N%2==0, times = N^2/4
  // if N%2==1, times = (N^2-1)/4
  public static void sort(Comparable[] a) {
    int timeFail = 0;
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[min])) {
          min = j;
          timeFail++;
        }
      }
      exch(a, i, min);
    }
    StdOut.println("timeFail: " + timeFail);
  }

  public static void main(String[] args) {
    Integer[] a = ArrayGenerator.descIntArray(9);
    PrintUtil.show(a);
    sort(a);
    a = ArrayGenerator.descIntArray(99);
    PrintUtil.show(a);
    sort(a);
    a = ArrayGenerator.descIntArray(8);
    PrintUtil.show(a);
    sort(a);
//    9 8 7 6 5 4 3 2 1 0
//    timeFail: 25
//    99 98 97 96 95 94 93 92 91 90 89 88 87 86 85 84 83 82 81 80 79 78 77 76 75 74 73 72 71 70 69 68 67 66 65 64 63 62 61 60 59 58 57 56 55 54 53 52 51 50 49 48 47 46 45 44 43 42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0
//    timeFail: 2500
//    8 7 6 5 4 3 2 1 0
//    timeFail: 20
  }
}
