package designpattern.u2.v1;

/**
 * Created by HuGuodong on 2019/11/10.
 */
public class Casher {

  private double total;

  public Casher() {

  }

  public void add(double price, int num) {
    total += price * num;
  }

  public double getTotal() {
    return total;
  }
}
