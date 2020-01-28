package Ch_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 1/29/20.
 */
public class _TestSearch {

  public static void main(String[] args) {
    _AdjListGraph G = new _AdjListGraph(new In("algdata/tinyCG.txt"));
    int s = 0;
    _DepthFirstSearch search = new _DepthFirstSearch(G, s);

    for (int v = 0; v < G.V(); v++) {
      if(search.marked(v)){
        StdOut.print(v + " ");
      }
    }
    StdOut.println();
    if (search.count() != G.V())
      StdOut.print("NOT ");
    StdOut.println("connected");
//    0 1 2 3 4 5 6
//    NOT connected

  }
}
