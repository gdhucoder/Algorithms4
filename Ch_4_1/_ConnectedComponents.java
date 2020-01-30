package Ch_4_1;

/**
 * Created by HuGuodong on 1/30/20.
 */
public class _ConnectedComponents {

  private boolean[] marked;
  private int[] id;
  private int count;

  public _ConnectedComponents(_AdjListGraph G) {
    marked = new boolean[G.V()];
    id = new int[G.V()];
    for (int v = 0; v < G.V(); v++) {
      if (!marked[v]) {
        dfs(G, v);
        count++;
      }

    }
  }

  private void dfs(_AdjListGraph G, int v) {
    // process
    marked[v] = true;
    id[v] = count;
    // drill down
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        dfs(G, w);
      }
    }
  }

  /**
   * how many components
   *
   * @return
   */
  public int count() {
    return count;
  }

  /**
   * component identifier for v
   *
   * @param v
   * @return
   */
  public int id(int v) {
    return id[v];
  }

}
