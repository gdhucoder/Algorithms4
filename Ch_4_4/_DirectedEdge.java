package Ch_4_4;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/30.
 */

public class _DirectedEdge {

  private final int v;
  private final int w;
  private final double weight;

  public _DirectedEdge(int v, int w, double weight){
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public double weight(){
    return weight;
  }

  public int from(){
    return v;
  }

  public int to(){
    return w;
  }

  public String toString(){
    return String.format("%d->%d %5.2f", v, w, weight);
  }

  public static void main(String[] args) {
    _DirectedEdge e = new _DirectedEdge(5,10, 2.22);
    StdOut.println(e);
  }
}
