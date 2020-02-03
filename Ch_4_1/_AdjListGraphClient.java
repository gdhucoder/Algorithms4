package Ch_4_1;

import edu.princeton.cs.algs4.In;

/**
 * Created by HuGuodong on 1/28/20.
 */
public class _AdjListGraphClient {

  public static void main(String[] args) {
    _AdjListGraph g = new _AdjListGraph(new In("algdata/tinyGex2.txt"));
    System.out.println(g);
//    13 vertices, 13 edges
//    0:6 2 1 5
//    1:0
//    2:0
//    3:5 4
//    4:5 6 3
//    5:3 4 0
//    6:0 4
//    7:8
//    8:7
//    9:11 10 12
//    10:9
//    11:9 12
//    12:11 9
  }
}
