package designpattern.u6.v2;

/**
 * Created by HuGuodong on 2019/11/19.
 */
public abstract class Finery {

  public abstract void show();
}

class TShirt extends Finery {

  @Override
  public void show() {
    System.out.println("Wear T-Shirt");
  }
}

class Shoes extends Finery {

  @Override
  public void show() {
    System.out.println("Wear Shoes");
  }
}