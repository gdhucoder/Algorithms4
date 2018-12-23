package Ch_4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/23.
 */

public class _EdgeWeightedGraph {

  private final int V; // number of vertices
  private int E; // number of edges
  private Bag<_Edge>[] adj; // adjacency lists

  private static final String NEWLINE = System.getProperty("line.separator");

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

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public void addEdge(_Edge e) {
    int v = e.either();
    int w = e.other(v);
    adj[v].add(e);
    adj[w].add(e);
    E++;
  }

  public Iterable<_Edge> adj(int v) {
    return adj[v];
  }

  // put all edges in a Bag
  public Iterable<_Edge> edges() {
    Bag<_Edge> edges = new Bag<>();
    for (int v = 0; v < V; v++) {
      for (_Edge e : adj[v]) {
        if (e.other(v) > v) {
          edges.add(e);
        }
      }
    }
    return edges;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(V + " " + E + NEWLINE);
    for (int v = 0; v < V; v++) {
      s.append(v + ": ");
      for (_Edge e : adj[v]) {
        s.append(e + " ");
      }
      s.append(NEWLINE);
    }
    return s.toString();
  }

  public static void main(String[] args) {
    String[] files = {"tinyEWG.txt", "mediumEWG.txt", "largeEWG.txt"};
    _EdgeWeightedGraph weightedGraph = new _EdgeWeightedGraph(new In(files[1]));

    StdOut.println(weightedGraph);

  }
}
