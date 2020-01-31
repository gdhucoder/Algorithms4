package Ch_4_1;

/**
 * Created by HuGuodong on 2/1/20.
 */
public class _Cycle {

  private boolean[] marked;
  private boolean hasCycle;

  public _Cycle(_AdjListGraph G) {
    marked = new boolean[G.V()];
    for (int s = 0; s < G.V(); s++) {
      dfs(G, s, s);
    }
  }

  private void dfs(_AdjListGraph G, int u, int v) {
    marked[u] = true;
    for (int w : G.adj(u)) {
      if (!marked[w]) {
        dfs(G, w, u);
      } else if (w != u) {
        hasCycle = true;
      }
    }
  }

  public boolean hasCycle() {
    return hasCycle;
  }
}
