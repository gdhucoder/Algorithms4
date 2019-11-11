package designpattern.u2.v3;

/**
 * Created by HuGuodong on 2019/11/11.
 */
public class Client {

  public static void main(String[] args) {
    // client needs to know two classes : CashSuper, CashFactory
    // we need more encapsulation
    CashSuper cs = CashFactory.createCaseAccept(1); // discount
    double total = cs.acceptCash(1000);
    System.out.println(total);
  }
}
