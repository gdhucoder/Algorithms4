package designpattern.u19;

/**
 * Created by HuGuodong on 12/16/19.
 */
public abstract class Phone {

  protected String brand;

  public Phone(String brand) {
    this.brand = brand;
  }

  abstract void call();

  abstract void play();
}

class iPhone extends Phone {

  public iPhone() {
    super("iPhone");
  }

  @Override
  void call() {
    System.out.println(brand + " call");
  }

  @Override
  void play() {
    System.out.println(brand + " play");
  }
}

class HuaWei extends Phone {

  public HuaWei() {
    super("HuaWei");
  }

  @Override
  void call() {
    System.out.println(brand + " call");
  }

  @Override
  void play() {
    System.out.println(brand + " play");
  }
}