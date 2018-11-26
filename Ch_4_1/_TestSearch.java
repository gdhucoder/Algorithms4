package Ch_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/27.
 */

public class _TestSearch {

  public static void main(String[] args) {
    _Graph G = new _Graph(new In((args[0])));
    int s = Integer.parseInt(args[1]);
    _Search search = new _Search(G, s);

    for (int v = 0; v < G.V(); v++) {
      if(search.marked(v)){
        StdOut.print(v+"\t");
      }
    }
    StdOut.println();

    if(search.count() != G.V()){
      StdOut.print("NOT");
    }
    StdOut.println("connected");

  }

}
