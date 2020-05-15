package Ch_4_4;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by HuGuodong on 5/16/20.
 */
public class _AcyclicSP {

  private _DirectedEdge[] edgeTo;
  private double[] distTo;

  /**
   * for acyclic digraph relax vertex in toplogical order each edge is relaxed exactly once!
   *
   * @param G
   * @param s
   */
  public _AcyclicSP(_EdgeWeightedDigraph G, int s) {
    edgeTo = new _DirectedEdge[G.V()];
    distTo = new double[G.V()];
    for (int v = 0; v < G.V(); v++) {
      distTo[v] = Double.POSITIVE_INFINITY;
    }
    //    Topological top = new Topological(G);
  }

  private void relax(_EdgeWeightedDigraph G, int v) {
    for (_DirectedEdge e : G.adj(v)) {
      int w = e.to();
      if (distTo[w] > distTo[v] + e.weight()) {
        distTo[w] = distTo[v] + e.weight();
        edgeTo[w] = e;
      }
    }
  }

  public double distTo(int v) {
    return distTo[v];
  }

  public boolean hasPathTo(int v) {
    return distTo[v] < Double.POSITIVE_INFINITY;
  }

  public Iterable<_DirectedEdge> pathTo(int v) {
    if (!hasPathTo(v)) return null;
    Stack<_DirectedEdge> path = new Stack<>();
    for (_DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
      path.push(e);
    return path;
  }
}
