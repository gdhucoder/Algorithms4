package Ch_4_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/8.
 */

public class _DirectedDFS {


  private boolean[] marked;

  public _DirectedDFS(_Digraph G, int s) {
    marked = new boolean[G.V()];
    dfs(G, s);
  }

  public _DirectedDFS(_Digraph G, Iterable<Integer> sources) {
    marked = new boolean[G.V()];
    for (int s : sources)
      if (!marked[s])
        dfs(G, s);
  }

  public void dfs(_Digraph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (!marked[w])
        dfs(G, w);
    }
  }

  public boolean marked(int v) {
    return marked[v];
  }

  public static void main(String[] args) {
    _Digraph G = new _Digraph(new In("src/main/algs4-data/tinyDG.txt"));
    Bag<Integer> sources = new Bag<>();
//    sources.add(1);
    sources.add(2);
//    sources.add(6);

    _DirectedDFS reachable = new _DirectedDFS(G, sources);

    for (int v = 0; v < G.V(); v++) {
      if (reachable.marked(v))
        StdOut.print(v + " ");
    }
    StdOut.println();
  }

}
