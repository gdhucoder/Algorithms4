package Ch_4_4;

/**
 * Created by HuGuodong on 5/16/20.
 */
public class _DijstraAllPairsSP {

  private _DijkstraSP[] all;

  public _DijstraAllPairsSP(_EdgeWeightedDigraph G) {
    all = new _DijkstraSP[G.V()];
    for (int v = 0; v < G.V(); v++) {
      all[v] = new _DijkstraSP(G, v);
    }
  }

  public Iterable<_DirectedEdge> path(int s, int t) {
    return all[s].pathTo(t);
  }

  public double dist(int s, int t) {
    return all[s].distTo(t);
  }
}
