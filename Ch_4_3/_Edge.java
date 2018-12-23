package Ch_4_3;

/**
 * Created by HuGuodong on 2018/12/23.
 */

public class _Edge implements Comparable<_Edge> {

  private final int v; // one vertex
  private final int w; // the other
  private final double weight; // edge weight

  public _Edge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public double weight() {
    return weight;
  }

  public int either() {
    return v;
  }

  public int other(int vertex) {
    if (vertex == v) {
      return w;
    } else if (vertex == w) {
      return v;
    }else {
      throw new RuntimeException("Inconsistent Edge!");
    }
  }


  @Override
  public int compareTo(_Edge that) {

    return this.weight() > that.weight() ? 1 :
        this.weight() == that.weight() ? 0 : -1;
  }

  @Override
  public String toString() {
    return String.format("%d-%d %.2f", v, w, weight);
  }
}
