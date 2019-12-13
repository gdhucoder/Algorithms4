package geekbang.ALGO.u31;

import edu.princeton.cs.algs4.In;

/**
 * Created by HuGuodong on 12/14/19.
 */
public class Client {

  public static void main(String[] args) {
    Graph g = new Graph(new In("geekbang/ALGO/u31/data.txt"));
    g.bfs(0, 6);
//    0 1 4 6
  }
}
