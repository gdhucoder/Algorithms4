package Ch_4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by HuGuodong on 5/5/20.
 */
public class _EdgeWeightedGraph {

  private final int V; // number of vertices
  private int E;
  private Bag<_Edge>[] adj; // adjacency lists

  public _EdgeWeightedGraph(int V) {
    this.V = V;
    this.E = 0;
    adj = (Bag<_Edge>[]) new Bag[V];
    for (int v = 0; v < V; v++) {
      adj[v] = new Bag<>();
    }
  }

  public _EdgeWeightedGraph(In in) {
    this(in.readInt());
    int E = in.readInt();
    for (int i = 0; i < E; i++) {
      int v = in.readInt();
      int w = in.readInt();
      double weight = in.readDouble();
      _Edge e = new _Edge(v, w, weight);
      addEdge(e);
    }
  }

  public void addEdge(_Edge e) {
    int v = e.either(), w = e.other(v);
    adj[v].add(e);
    adj[w].add(e);
    E++;
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public Iterable<_Edge> adj(int v) {
    return adj[v];
  }

  public Iterable<_Edge> edges() {
    Bag<_Edge> b = new Bag<>();
    for (int v = 0; v < V; v++) {
      for (_Edge e : adj[v]) {
        if (e.other(v) > v) b.add(e);
      }
    }
    return b;
  }

  @Override
  public String toString() {
    String s = V + " vertices, " + E + " edges\n";
    for (int v = 0; v < V; v++) {
      s += v + ": ";
      for (_Edge e : adj(v)) {
        s += e.toString();
      }
      s += "\n";
    }
    return s;
  }

  public static void main(String[] args) {
    _EdgeWeightedGraph g = new _EdgeWeightedGraph(new In("algdata/tinyEWD.txt"));
    System.out.println(g);
    //    8 vertices, 15 edges
    //    0: 6-0 0.58 	0-2 0.26 	0-4 0.38
    //    1: 1-3 0.29 	5-1 0.32
    //    2: 6-2 0.40 	2-7 0.34 	0-2 0.26
    //    3: 3-6 0.52 	1-3 0.29 	7-3 0.39
    //    4: 6-4 0.93 	0-4 0.38 	4-7 0.37 	5-4 0.35 	4-5 0.35
    //    5: 5-1 0.32 	7-5 0.28 	5-7 0.28 	5-4 0.35 	4-5 0.35
    //    6: 6-4 0.93 	6-0 0.58 	3-6 0.52 	6-2 0.40
    //    7: 2-7 0.34 	7-3 0.39 	7-5 0.28 	5-7 0.28 	4-7 0.37
  }
}
