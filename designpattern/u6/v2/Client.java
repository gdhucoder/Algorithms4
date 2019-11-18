package designpattern.u6.v2;

/**
 * Created by HuGuodong on 2019/11/19.
 */
public class Client {

  public static void main(String[] args) {
    Person p = new Person("Ming");
    Finery tshirt = new TShirt();
    Finery shoes = new Shoes();
    tshirt.show();
    shoes.show();
    p.show();
  }
}
