package Ch_4_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2/21/20.
 */
public class _DirectedDFS {

  private boolean[] marked;

  public _DirectedDFS(_AdjListDigraph G, int s) {
    marked = new boolean[G.V()];
    dfs(G, s);
  }

  public _DirectedDFS(_AdjListDigraph G, Iterable<Integer> sources) {
    marked = new boolean[G.V()];
    for (int s : sources) {
      if (!marked[s]) {
        dfs(G, s);
      }
    }
  }

  public boolean marked(int v) {
    return marked[v];
  }

  private void dfs(_AdjListDigraph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        dfs(G, w);
      }
    }
  }

  public static void main(String[] args) {
    String filePath = "algdata/tinyDG.txt";
    _AdjListDigraph G = new _AdjListDigraph(new In(filePath));
    Bag<Integer> sources = new Bag<>();
    sources.add(1);
    sources.add(2);
    sources.add(6);
    _DirectedDFS reachable = new _DirectedDFS(G, sources);
    for (int v = 0; v < G.V(); v++) {
      if (reachable.marked(v)) {
        StdOut.print(v + " ");
      }
    }
    StdOut.println();

  }
}
