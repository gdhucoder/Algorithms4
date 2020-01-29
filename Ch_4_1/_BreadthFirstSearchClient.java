package Ch_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 1/30/20.
 */
public class _BreadthFirstSearchClient {

  public static void main(String[] args) {
    _AdjListGraph G = new _AdjListGraph(new In("algdata/tinyCG.txt")); // graph init
    int s = 0; // source
    _BreadthFirstSearch search = new _BreadthFirstSearch(G, s);
    for (int v = 0; v < G.V(); v++) {
      StdOut.print(s + " to " + v + ": ");
      if (search.hasPathTo(v)) {
        for (int x : search.pathTo(v)) {
          if (x == s) {
            StdOut.print(x);
          } else {
            StdOut.print("-" + x);
          }
        }
        StdOut.println();
      }
    }
  }
}
