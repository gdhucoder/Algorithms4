package designpattern.u02.v4;

/**
 * Created by HuGuodong on 2019/11/11.
 */
public class Client {

  /**
   * only dispose CashContext Class
   *
   * @param args
   */
  public static void main(String[] args) {
    CashContext cc = new CashContext(1);
    double total = cc.getResult(1000);
    System.out.println(total);
  }
}
