package Ch_4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Connected Components
 * DFS to find connected components in a graph
 * Created by HuGuodong on 2018/12/3.
 */

public class _CC {

  private boolean[] marked;
  private int[] id;
  private int count;

  // preprocessing constructor
  public _CC(_Graph G) {
    marked = new boolean[G.V()];
    id = new int[G.V()];
    for (int s = 0; s < G.V(); s++) {
      if (!marked[s]) {
        dfs(G, s);
        count++;
      }
    }
  }

  private void dfs(_Graph G, int v) {
    marked[v] = true;
    id[v] = count;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        dfs(G, w);
      }
    }
  }

  // are v and w connected?
  public boolean connected(int v, int w) {
    return id[v] == id[w];
  }

  // component identifier for v
  public int id(int v) {
    return id[v]; // between 0 and count() - 1
  }

  // number of connected components
  public int count() {
    return count;
  }

  // 查找连通分量
  // read a input
  // and print all vertices in the same connected component
  public static void main(String[] args) {
    _AdjListGraph g = new _AdjListGraph(new In("src/main/algs4-data/tinyG.txt"));
    _CC c = new _CC(g);

    int M = c.count();
    StdOut.println(M + " components");

    Bag<Integer>[] components;
    components = new Bag[M];

    for (int i = 0; i < M; i++) {
      components[i] = new Bag<>();
    }

    for (int v = 0; v < g.V(); v++) {
      components[c.id(v)].add(v);
    }

    for (int i = 0; i < M; i++) {
      for (int v : components[i]) {
        StdOut.print(v + " ");
      }
      StdOut.println();
    }

  }

}
