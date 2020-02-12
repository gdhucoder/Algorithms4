package Ch_4_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by HuGuodong on 2/12/20.
 */
public class _AdjListDigraph {

  private final int V; // number of vertices
  private int E;
  private Bag<Integer>[] adj;

  public _AdjListDigraph(int V) {
    this.V = V;
    this.E = 0;
    adj = (Bag<Integer>[]) new Bag[V];
    for (int i = 0; i < V; i++) {
      adj[i] = new Bag<>();
    }
  }

  public _AdjListDigraph(In in) {
    this(in.readInt());
    int E = in.readInt();
    for (int i = 0; i < E; i++) {
      int v = in.readInt();
      int w = in.readInt();
      addEdge(v, w);
    }
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    E++;
  }
}
