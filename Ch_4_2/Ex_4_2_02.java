package Ch_4_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2/21/20.
 */
public class Ex_4_2_02 {

  public static void main(String[] args) {
    String filePath = "algdata/tinyGex2.txt";
    _AdjListDigraph G = new _AdjListDigraph(new In(filePath));
    StdOut.println(G);
    //    12 vertices, 16 edges
    //    0->6
    //    1->11
    //    2->0->3
    //    3->6
    //    4->1
    //    5->0->10->2
    //    6->2
    //    7->8->11
    //    8->1->4
    //    9
    //    10->3
    //    11->8
  }
}
