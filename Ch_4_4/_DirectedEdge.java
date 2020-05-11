package Ch_4_4;

/**
 * Created by HuGuodong on 5/12/20.
 */
public class _DirectedEdge {

  private final int v;
  private final int w;
  private final double weight;

  public _DirectedEdge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public double weight() {
    return this.weight;
  }

  public int from() {
    return this.v;
  }

  public int to() {
    return this.w;
  }

  @Override
  public String toString() {
    return String.format("%d->%d %.2f", v, w, weight);
  }
}
