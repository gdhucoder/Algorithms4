package Ch_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/3.
 */

public class _BreadthFirstPaths {

  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public _BreadthFirstPaths(_Graph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    bfs(G, s);
  }

  private void bfs(_Graph G, int s) {
    Queue<Integer> queue = new Queue<>();
    marked[s] = true;
    queue.enqueue(s);
    while (!queue.isEmpty()) {
      int v = queue.dequeue();
      for (int w : G.adj(v)) {
        if (!marked[w]) {
          edgeTo[w] = v;
          marked[w] = true;
          queue.enqueue(w);
        }
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) {
      return null;
    }
    Stack<Integer> path = new Stack<>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(s);
    return path;
  }

  public static void main(String[] args) {
    _AdjListGraph g = new _AdjListGraph(new In("algdata/tinyCG.txt"));
    int s = 0;
    _BreadthFirstPaths bfs = new _BreadthFirstPaths(g, s);
    for (int v = 0; v < g.V(); v++) {
      StdOut.printf("%d to %d: ", s, v);
      if(bfs.hasPathTo(v)){
        for(int x : bfs.pathTo(v)){
          StdOut.print(x+" ");
        }
        StdOut.println();
      }else{
        StdOut.println("are not CONNECTED!");
      }
    }
  }

}
