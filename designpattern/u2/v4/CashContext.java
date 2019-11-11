package designpattern.u2.v4;


/**
 * Created by HuGuodong on 2019/11/11.
 */
public class CashContext {

  private CashSuper cs;

  public CashContext(int type) {
    if (type == 0) {
      cs = new CashNormal();
    } else if (type == 1) {
      cs = new Discount(0.8);
    }
  }

  public double getResult(double money) {
    return cs.acceptCash(money);
  }
}
