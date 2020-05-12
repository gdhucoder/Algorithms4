package Ch_4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 5/12/20.
 */
public class TestDijkstraSP {

  public static void main(String[] args) {
    _EdgeWeightedDigraph G = new _EdgeWeightedDigraph(new In("algdata/tinyEWD.txt"));
    StdOut.println(G);
    int s = 0;
    _DijkstraSP sp = new _DijkstraSP(G, s);
    for (int t = 0; t < G.V(); t++) {
      StdOut.print(s + " to " + t);
      StdOut.printf(" (%4.2f): ", sp.distTo(t));
      if (sp.hasPathTo(t)) {
        for (_DirectedEdge e : sp.pathTo(t)) {
          StdOut.print(e + " ");
        }
      }
      StdOut.println();
    }
    //    0 to 0 (0.00):
    //    0 to 1 (1.05): 0->4 0.38 4->5 0.35 5->1 0.32
    //    0 to 2 (0.26): 0->2 0.26
    //    0 to 3 (0.99): 0->2 0.26 2->7 0.34 7->3 0.39
    //    0 to 4 (0.38): 0->4 0.38
    //    0 to 5 (0.73): 0->4 0.38 4->5 0.35
    //    0 to 6 (1.51): 0->2 0.26 2->7 0.34 7->3 0.39 3->6 0.52
    //    0 to 7 (0.60): 0->2 0.26 2->7 0.34
  }
}
