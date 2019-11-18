package designpattern.u6.v3;

/**
 * Created by HuGuodong on 2019/11/19.
 */
public class Person {

  private String name;

  public Person() {}

  public Person(String name) {
    this.name = name;
  }

  public void show() {
    System.out.println("打扮的 " + name);
  }
}

class Finery extends Person {

  protected Person component;

  public void decorate(Person component) {
    this.component = component;
  }

  @Override
  public void show() {
    if (component != null) {
      component.show();
    }
  }
}

class TShirt extends Finery {

  @Override
  public void show() {
    System.out.println("Wear T- Shirt");
    super.show();
  }
}

class Sneaker extends Finery {

  @Override
  public void show() {
    System.out.println("Wear Sneaker");
    super.show();
  }
}