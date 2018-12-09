package Ch_4_2;

import Ch_4_1._Graph;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/7.
 */

public class _Digraph {

  private final int V;
  private int E;
  private Bag<Integer>[] adj;

  public _Digraph(int V) {
    this.V = V;
    this.E = 0;
    adj = (Bag<Integer>[]) new Bag[V];
    for (int v = 0; v < V; v++)
      adj[v] = new Bag<>();
  }

  public _Digraph(In in) {
    this(in.readInt());
    int E = in.readInt();
    for (int i = 0; i < E; i++) {
      int v = in.readInt();
      int w = in.readInt();
      addEdge(v, w);
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    E++;
  }

  public Iterable<Integer> adj(int v) {
    return adj[v];
  }

  public _Digraph reverse() {
    _Digraph rev = new _Digraph(V);
    for (int v = 0; v < V; v++)
      for (int w : adj(v))
        rev.addEdge(w, v);
    return rev;
  }

  @Override
  public String toString() {

    return super.toString();
  }

  public static void show(_Digraph G){
    for (int v = 0; v < G.V(); v++) {
      StdOut.print(v);
      for (int w : G.adj(v))
        StdOut.print(" - " + w);
    }
    StdOut.println();
  }



  public static void main(String[] args) {
    _Digraph dg = new _Digraph(new In("src/main/algs4-data/tinyDG.txt"));

    show(dg);

    StdOut.println("该图的反向图");
    show(dg.reverse());

//    0 - 5 - 1
//    1
//    2 - 0 - 3
//    3 - 5 - 2
//    4 - 3 - 2
//    5 - 4
//    6 - 9 - 4 - 8 - 0
//    7 - 6 - 9
//    8 - 6
//    9 - 11 - 10
//    10 - 12
//    11 - 4 - 12
//    12 - 9

  }
}
