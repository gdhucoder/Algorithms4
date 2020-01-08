package designpattern.u02.v2;

/**
 * Created by HuGuodong on 2019/11/10.
 */
public class Client {

  /**
   * add discount
   *
   * @param args
   */
  public static void main(String[] args) {
    Casher casher = new Casher();
    casher.add(0, 100.0, 10);
    casher.add(1, 100.0, 10);
    casher.add(2, 100.0, 10);

    System.out.println("Total is: " + casher.getTotal()); // 2500.0
  }
}
