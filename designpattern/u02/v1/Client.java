package designpattern.u02.v1;

/**
 * Created by HuGuodong on 2019/11/10.
 */
public class Client {

  public static void main(String[] args) {
    Casher casher = new Casher();
    casher.add(100, 1);
    casher.add(500, 2);
    System.out.println("Total is: " + casher.getTotal());
  }
}
