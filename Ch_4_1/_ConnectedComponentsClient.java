package Ch_4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 1/30/20.
 */
public class _ConnectedComponentsClient {

  public static void main(String[] args) {
    _AdjListGraph G = new _AdjListGraph(new In("algdata/tinyG.txt"));
    System.out.println(G);

    _ConnectedComponents CC = new _ConnectedComponents(G);
    int M = CC.count();
    System.out.println(M + " components.");

    // init components list
    Bag<Integer>[] components;
    components = (Bag<Integer>[]) new Bag[M];
    for (int i = 0; i < M; i++) {
      components[i] = new Bag<Integer>();
    }

    // set components list
    for (int v = 0; v < G.V(); v++) {
      components[CC.id(v)].add(v);
    }

    // print vertex
    for (int i = 0; i < M; i++) {
      for (int v : components[i]) {
        StdOut.print(v + " ");
      }
      StdOut.println();
    }
  }
}
