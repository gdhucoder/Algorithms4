package Ch_4_2;

import Ch_4_1._AdjListGraph;
import Ch_4_1._SymbolGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/12.
 */

public class _SymbolDigraph {
  // the same with SymbolGraph, replace Digraph with Graph

  private ST<String, Integer> st; // string -> index
  private String[] keys; // index -> string
  private _Digraph G;

  public _SymbolDigraph(String stream, String sp) {
    st = new ST<>();
    In in = new In(stream);

    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);
      for (int i = 0; i < a.length; i++) {
        if (!st.contains(a[i])) {
          st.put(a[i], st.size());
        }
      }
    }

    keys = new String[st.size()];
    for (String key : st.keys()) {
      keys[st.get(key)] = key;
    }

    G = new _Digraph(st.size());
    // second pass
    in = new In(stream);

    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);
      int v = st.get(a[0]); // first vertex
      for (int i = 1; i < a.length; i++) {
        G.addEdge(v, st.get(a[i]));
      }
    }

  }

  public boolean contains(String key) {
    return st.contains(key);
  }

  public int index(String key) {
    return st.get(key);
  }

  public String name(int v) {
    return keys[v];
  }

  public _Digraph G() {
    return G;
  }

  public static void main(String[] args) {

    String filename = "jobs.txt";
    String delim = "/";
    _SymbolDigraph sg = new _SymbolDigraph(filename, delim);
    _Digraph G = sg.G();

    for (int v = 0; v < G.V(); v++) {
      StdOut.print(sg.name(v) + ": ");
      for (int w : G.adj(v)) {
        StdOut.print(sg.name(w) + ", ");
      }
      StdOut.println();
    }

  }
}
