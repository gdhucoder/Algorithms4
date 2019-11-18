package designpattern.u6.v1;

/**
 * Created by HuGuodong on 2019/11/19.
 */
public class Person_v1 {

  private String name;

  public Person_v1(String name) {
    this.name = name;
  }

  public void wearTShirts() {
    System.out.println("Wear T Shirts");
  }

  public void wearCoat() {
    System.out.println("Wear Coat");
  }

  public void show() {
    System.out.println(name);
  }

  public static void main(String[] args) {
    Person_v1 p = new Person_v1("Mingming");
    p.show();
    p.wearCoat();
    p.wearTShirts();

    Person_v1 p1 = new Person_v1("Gang");
    p.show();
    p1.wearTShirts();
  }
}
