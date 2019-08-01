package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/8/1.
 */

public class Ex_1_3_45 {

  /**
   * if count < 0 then underflow
   */
  public static boolean isUnderflow(String input) {
    char[] chars = input.toCharArray();
    int count = 0;
    for (char c : chars) {
      if (count < 0) {
        return true;
      }
      if (c == '-') {
        count--;
      } else {
        count++;
      }

    }
    return false;
  }

  public static boolean isPossiblePermutations(Integer[] a) {

    int i = 0;
    int N = a.length;
    _Stack<Integer> s = new _Stack<>();
    for (int num : a) {
      while (i <= num && i <= N) {
        s.push(i++);
      }
      if (s.peek() > num) {
        break;
      }
      if (s.peek() == num) {
        s.pop();
      }
    }
    return s.isEmpty();
  }

  public static void main(String[] args) {
    String a = "1 - 2 3 4 - - - -".replaceAll("\\s+", "");
    StdOut.printf("%s is underflow ? %s\n", a, isUnderflow(a));
    // 1-234---- is underflow ? true
    a = "1 - - - - 2 3 4 -".replaceAll("\\s+", "");
    StdOut.printf("%s is underflow ? %s\n", a, isUnderflow(a));

    for (int i = 0; i < 10000; i++) {
      Integer[] arr = ArrayGenerator.descIntArray(10);
      StdRandom.shuffle(arr);
      boolean possible = isPossiblePermutations(arr);
      if (possible) {
        PrintUtil.show(arr);
        StdOut.println(isPossiblePermutations(arr));
      }
    }
//    0 1 7 9 10 8 6 5 4 3 2
//    true
//    4 5 3 2 6 7 1 0 9 8 10
//    true
//    1 5 4 3 2 6 9 8 7 10 0
//    true
//    2 1 6 5 4 3 7 0 8 10 9
//    true
//    0 1 2 4 3 7 8 6 5 10 9
//    true
//    4 5 6 8 7 3 2 1 0 10 9
//    true
//    1 3 4 2 5 7 6 9 10 8 0
//    true
//    1 2 6 8 7 5 4 3 10 9 0
//    true
//    2 1 4 5 3 8 9 7 6 0 10
//    true
//    0 2 1 4 5 3 7 8 9 6 10
//    true
//    1 0 3 2 4 5 7 8 6 10 9
//    true
//    5 4 8 7 9 6 3 2 1 10 0
//    true
//    0 3 2 1 6 5 9 8 7 10 4
//    true
//    1 2 0 3 7 6 5 4 10 9 8
//    true
//    2 4 6 5 8 7 3 1 0 10 9
//    true

  }
}
