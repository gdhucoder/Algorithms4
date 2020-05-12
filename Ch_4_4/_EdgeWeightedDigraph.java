package Ch_4_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by HuGuodong on 5/12/20.
 */
public class _EdgeWeightedDigraph {

  private final int V;
  private int E;
  private Bag<_DirectedEdge>[] adj;

  public _EdgeWeightedDigraph(int V) {
    this.V = V;
    this.E = 0;
    adj = new Bag[V];
    for (int v = 0; v < V; v++) {
      adj[v] = new Bag<>();
    }
  }

  public _EdgeWeightedDigraph(In in) {
    this(in.readInt());
    int E = in.readInt();
    for (int i = 0; i < E; i++) {
      int v = in.readInt();
      int w = in.readInt();
      double weight = in.readDouble();
      _DirectedEdge e = new _DirectedEdge(v, w, weight);
      addEdge(e);
    }
  }

  public int V() {
    return this.V;
  }

  public int E() {
    return this.E;
  }

  public void addEdge(_DirectedEdge e) {
    adj[e.from()].add(e);
    E++;
  }

  public Iterable<_DirectedEdge> adj(int v) {
    return adj[v];
  }

  public Iterable<_DirectedEdge> edges() {
    Bag<_DirectedEdge> bag = new Bag<>();
    for (int v = 0; v < V; v++) {
      for (_DirectedEdge e : adj[v]) {
        bag.add(e);
      }
    }
    return bag;
  }
}
