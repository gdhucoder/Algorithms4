package designpattern.u2.v3;

/**
 * Created by HuGuodong on 2019/11/11.
 */
public abstract class CashSuper {

  public abstract double acceptCash(double money);

}

class Discount extends CashSuper {

  private double discount = 1;

  public Discount(double discount) {
    this.discount = discount;
  }

  @Override
  public double acceptCash(double money) {
    return money * discount;
  }
}

class CashNormal extends CashSuper {

  @Override
  public double acceptCash(double money) {
    return money;
  }
}

class CashFactory {

  public static CashSuper createCaseAccept(int type) {
    CashSuper cs = null;
    if (type == 0) {
      cs = new CashNormal();
    } else if (type == 1)
      cs = new Discount(0.8);
    return cs;
  }

}