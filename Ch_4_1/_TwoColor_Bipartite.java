package Ch_4_1;

/**
 * Created by HuGuodong on 2/1/20.
 */
public class _TwoColor_Bipartite {

  private boolean[] marked;
  private boolean[] color;
  private boolean isTwoColorable = true;

  public _TwoColor_Bipartite(_AdjListGraph G) {
    marked = new boolean[G.V()];
    color = new boolean[G.V()];
    for (int s = 0; s < G.V(); s++) {
      dfs(G, s);
    }
  }

  private void dfs(_AdjListGraph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        marked[w] = true;
        color[w] = !color[v];
      } else if (color[w] == color[v]) {
        isTwoColorable = false;
      }
    }
  }

  public boolean isBipartite() {
    return isTwoColorable;
  }
}
