package Ch_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * Created by HuGuodong on 2/3/20.
 */
public class _SymbolGraph {

  private ST<String, Integer> st; // String -> index
  private String[] keys;
  private _AdjListGraph graph;

  public _SymbolGraph(String filename, String delimiter) {
    st = new ST<>();

    // First pass builds the index reading string to associate distinct strings
    // with an index
    In in = new In(filename);
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(delimiter);
      for (int i = 0; i < a.length; i++) {
        if (!st.contains(a[i]))
          st.put(a[i], st.size());
      }
    }

    // invert index to get string keys in an array
    keys = new String[st.size()];
    for (String name : st.keys()) {
      keys[st.get(name)] = name;
    }

    // second pass builds the graph by connecting first vertex on each
    // line to all others
    graph = new _AdjListGraph(st.size());
    in = new In(filename);
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(delimiter);
      int v = st.get(a[0]);
      for (int i = 1; i < a.length; i++) {
        int w = st.get(a[i]);
        graph.addEdge(v, w);
      }
    }
  }

  /**
   * Does the graph contain the vertex named {@code key}
   *
   * @param key the name of a vertex
   * @return
   */
  public boolean contains(String key) {
    return st.contains(key);
  }

  /**
   * index of a key
   *
   * @param key
   * @return -1
   */
  public int index(String key) {
    return st.get(key);
  }

  public String name(int v) {
    validateVertex(v);
    return keys[v];
  }

  public _AdjListGraph graph() {
    return graph;
  }

  /**
   * @return
   * @deprecated Replaced by {@link #graph()}.
   */
  @Deprecated
  public _AdjListGraph G() {
    return graph;
  }

  private void validateVertex(int v) {
    int V = graph.V();
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
  }

}
