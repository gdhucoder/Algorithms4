package Ch_4_1;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by HuGuodong on 1/29/20.
 */
public class _DepthFirstPaths {

  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public _DepthFirstPaths(_AdjListGraph G, int s) {
    this.s = s;
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    dfs(G, s);
  }

  private void dfs(_AdjListGraph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      }
    }
  }

  public boolean hashPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hashPathTo(v))
      return null;
    Stack<Integer> path = new Stack<>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(s);
    return path;
  }
}
