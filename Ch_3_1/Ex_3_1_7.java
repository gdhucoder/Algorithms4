package Ch_3_1;

import edu.princeton.cs.algs4.StdOut;
import tools.ArrayGenerator;

/**
 * Created by HuGuodong on 2018/11/12.
 */

public class Ex_3_1_7 {

  public static void main(String[] args) {
    int N = 1;
    for (int i = 1; i <= 6; i++) {
      N *= 10;
      Integer[] a = ArrayGenerator.Integers(N, 1000 - 1);
      _BinarySearchST<Integer, String> st = new _BinarySearchST(N);
      for (Integer key : a) {
        st.put(key, key + "");
      }
      StdOut.printf("for N = %10d, there are %6d distinct keys.\n", N, st.size());
//      for N =         10, there are     10 distinct keys.
//      for N =        100, there are     96 distinct keys.
//      for N =       1000, there are    627 distinct keys.
//      for N =      10000, there are   1000 distinct keys.
//      for N =     100000, there are   1000 distinct keys.
//      for N =    1000000, there are   1000 distinct keys.
    }

  }

}
