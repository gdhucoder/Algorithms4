package Ch_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2/4/20.
 */
public class Ex_4_1_02 {

  public static void main(String[] args) {
    _AdjListGraph G = new _AdjListGraph(new In("algdata/tinyGex2.txt"));
    StdOut.println(G);
//    12 vertices, 16 edges
//    0: 5 2 6
//    1: 4 8 11
//    2: 5 6 0 3
//    3: 10 6 2
//    4: 1 8
//    5: 0 10 2
//    6: 2 3 0
//    7: 8 11
//    8: 1 11 7 4
//    9:
//    10: 5 3
//    11: 8 7 1
  }
}
