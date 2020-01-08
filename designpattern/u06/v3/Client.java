package designpattern.u06.v3;

/**
 * Created by HuGuodong on 2019/11/19.
 */
public class Client {

  public static void main(String[] args) {
    Person p = new Person("Ming");
    Sneaker s = new Sneaker();
    TShirt t = new TShirt();
    s.decorate(p);
    t.decorate(s);
    t.show();
  }
}
