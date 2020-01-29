package Ch_4_1;

import Ch_1_3._Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by HuGuodong on 1/30/20.
 */
public class _BreadthFirstSearch {

  private boolean[] marked;
  private int[] edgeTo;

  private final int s;

  public _BreadthFirstSearch(_AdjListGraph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    bfs(G, s);
  }

  private void bfs(_AdjListGraph G, int s) {
    _Queue<Integer> queue = new _Queue<>();
    queue.enqueue(s);
    marked[s] = true;
    while (!queue.isEmpty()) {
      int v = queue.dequeue();
      for (int w : G.adj(v)) {
        if (!marked[w]) {
          marked[w] = true;
          edgeTo[w] = v;
          queue.enqueue(w);
        }
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v))
      return null;
    Stack<Integer> path = new Stack<>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(s);
    return path;
  }

}
