package designpattern.u2.v2;

/**
 * Created by HuGuodong on 2019/11/10.
 */
public class Casher {

  private final static int FULL = 0;
  private final static int DISCOUNT_8 = 1;
  private final static int DISCOUNT_7 = 2;
  private final static int DISCOUNT_6 = 3;

  private double total;

  public Casher() {

  }

  public void add(double price, int num) {
    total += price * num;
  }

  public void add(double price, int num, double discount) {
    total += price * num * discount;
  }

  public void add(int discountType, double price, int num) {
    switch (discountType) {
      case FULL:
        add(price, num);
        break;
      case DISCOUNT_8:
        add(price, num, 0.8);
        break;
      case DISCOUNT_7:
        add(price, num, 0.7);
        break;
      case DISCOUNT_6:
        add(price, num, 0.6);
        break;
    }
  }

  public double getTotal() {
    return total;
  }
}
