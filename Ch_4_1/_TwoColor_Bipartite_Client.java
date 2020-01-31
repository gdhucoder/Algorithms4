package Ch_4_1;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2/1/20.
 */
public class _TwoColor_Bipartite_Client {

  public static void main(String[] args) {
    _AdjListGraph G = new _AdjListGraph(new In("algdata/bipartite_test.txt"));
    _TwoColor_Bipartite bi = new _TwoColor_Bipartite(G);
    StdOut.println(G);
    StdOut.println(bi.isBipartite());
  }
}
