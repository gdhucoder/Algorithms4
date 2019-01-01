package Ch_4_4;

import Ch_4_3._Edge;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/30.
 */

public class _EdgeWeightedDigraph {

  private final int V;
  private int E;
  private Bag<_DirectedEdge>[] adj;

  private static final String NEWLINE = System.getProperty("line.separator");

  public _EdgeWeightedDigraph(int V){
    this.V = V;
    this.E = 0;
    adj = (Bag<_DirectedEdge>[]) new Bag[V];
    for (int v = 0; v < V; v++) {
      adj[v] = new Bag<>();
    }
  }

  public _EdgeWeightedDigraph(In in){
    this(in.readInt());
    int E = in.readInt();
    for (int i = 0; i < E; i++) {
      int v = in.readInt();
      int w = in.readInt();
      double weight = in.readDouble();
      _DirectedEdge edge = new _DirectedEdge(v, w, weight);
      addEdge(edge);
    }
  }

  public int V(){
    return V;
  }

  public int E(){
    return E;
  }

  public void addEdge(_DirectedEdge e){
    adj[e.from()].add(e);
    E++;
  }

  public Iterable<_DirectedEdge> adj(int v){
    return adj[v];
  }

  public Iterable<_DirectedEdge> edges(){
    Bag<_DirectedEdge> bag = new Bag<>();
    for (int v = 0; v < V; v++) {
      for(_DirectedEdge e : adj[v]){
        bag.add(e);
      }
    }
    return bag;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(V + " " + E + NEWLINE);
    for (int v = 0; v < V; v++) {
      s.append(v + ": ");
      for (_DirectedEdge e : adj[v]) {
        s.append(e + ", ");
      }
      s.setLength(s.length()-2); // 删除最后的空格
      s.append(NEWLINE);
    }
    return s.toString();
  }

  public static void main(String[] args) {
    _EdgeWeightedDigraph g = new _EdgeWeightedDigraph(new In("tinyEWD.txt"));
    StdOut.println(g);
  }
}
