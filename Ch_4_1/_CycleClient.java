package Ch_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2/1/20.
 */
public class _CycleClient {

  public static void main(String[] args) {
    _AdjListGraph G = new _AdjListGraph(new In("algdata/tinyG.txt"));
    _Cycle c = new _Cycle(G);
    boolean hasCycle = c.hasCycle();
    StdOut.println(G);
    StdOut.println("Has Cycle: " + hasCycle);
  }

}
