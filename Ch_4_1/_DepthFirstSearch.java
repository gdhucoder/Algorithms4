package Ch_4_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 1/29/20.
 */
public class _DepthFirstSearch {

  private boolean[] marked;
  private int count;

  public _DepthFirstSearch(_AdjListGraph G, int s) {
    marked = new boolean[G.V()];
    dfs(G, s, 0);
  }

  private void dfs(_AdjListGraph G, int v, int depth) {
    printTab(depth);
    StdOut.printf("dfs(%d)\n", v);
    marked[v] = true;
    count++;
    for (int w : G.adj(v)) {
      if (!marked[w])
        dfs(G, w, depth + 1);
      else {
        printTab(depth);
        StdOut.printf("|  check(%d)\n", w);
      }
    }
    printTab(depth);
    StdOut.printf("%d done\n", v);
  }

  private void printTab(int num) {

    for (int i = 0; i < num; i++) {
      StdOut.print(" ");
    }
  }

  /**
   * is w connected to s
   *
   * @param w
   * @return
   */
  public boolean marked(int w) {
    return marked[w];
  }

  /**
   * how many vertices are connected s?
   *
   * @return
   */
  public int count() {
    return count;
  }
}
