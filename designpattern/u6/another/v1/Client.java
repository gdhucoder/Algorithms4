package designpattern.u6.another.v1;

/**
 * Created by HuGuodong on 2019/11/19.
 */
public class Client {

  /**
   * https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
   *
   * @param args
   */
  public static void main(String[] args) {
    Shape c = new Circle();
    c.draw();
    Shape rc = new RedShapeDecorator(new Circle());
    rc.draw();
    Shape rr = new RedShapeDecorator(new Rectangle());
    rr.draw();

//    Draw circle
//    Draw circle
//    Border has been set.
//    Draw rectangle
//    Border has been set.

    // add more decorator
    Shape ry = new YellowShapeDecorator(rc);
    ry.draw();
//    Draw circle
//    Red Border has been set.
//    Yellow

  }
}
