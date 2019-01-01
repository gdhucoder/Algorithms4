package Ch_4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/30.
 */

public class _SP {

  public _SP(_EdgeWeightedDigraph G, int s){

  }

  public double distTo(int v){
    return 0;
  }

  public boolean hasPathTo(int v){
    return false;
  }

  public Iterable<_DirectedEdge> pathTo(int v){
    return null;
  }

  public static void main(String[] args) {
    _EdgeWeightedDigraph G = new _EdgeWeightedDigraph(new In(""));
    int s = 0;
    _SP sp = new _SP(G, s);
    for (int t = 0; t < G.V(); t++) {
      StdOut.print(s + " to " + t);
      StdOut.printf("(%4.2f)", sp.distTo(t));
      if(sp.hasPathTo(t)){
        for(_DirectedEdge e : sp.pathTo(t)){
          StdOut.print(e + " ");
        }
        StdOut.println();
      }

    }
  }
}
