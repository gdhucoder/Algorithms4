package Ch_4_2;

import Ch_4_2.Ex_4_2_03.Digraph;
import edu.princeton.cs.algs4.In;

/**
 * Created by HuGuodong on 3/14/20.
 */
public class Ex_4_2_04 {

  public static void main(String[] args) {
    String filePath = "algdata/tinyGex2.txt";
    Digraph G = new Digraph(new In(filePath));
    System.out.println(G);
    System.out.println(G.hasEdge(9, 11)); // false
    System.out.println(G.hasEdge(11, 4)); // false
    System.out.println(G.hasEdge(11, 8)); // true
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
    //
    //    false
    //    false
    //    true
  }
}
