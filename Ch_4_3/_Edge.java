package Ch_4_3;

/**
 * Created by HuGuodong on 5/5/20.
 */
public class _Edge implements Comparable<_Edge> {

  private final int v;
  private final int w;
  private final double weight;

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
    if (vertex == v) return w;
    else if (vertex == w) return v;
    else throw new RuntimeException("Inconsistent edge");
  }


  @Override
  public int compareTo(_Edge o) {
    return Double.compare(this.weight, o.weight);
  }

  public String toString() {
    return String.format("%d-%d %.2f \t", v, w, weight);
  }
}
