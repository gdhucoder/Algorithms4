package designpattern.u6.another.v1;

/**
 * Created by HuGuodong on 2019/11/19.
 */
public interface Shape {

  void draw();
}

class Circle implements Shape {

  @Override
  public void draw() {
    System.out.println("Draw circle");
  }
}

class Rectangle implements Shape {

  @Override
  public void draw() {
    System.out.println("Draw rectangle");
  }
}

abstract class ShapeDecorator implements Shape {

  protected Shape shape;

  //  public ShapeDecorator(){}
  public ShapeDecorator(Shape shape) {
    this.shape = shape;
  }

  @Override
  public void draw() {
    shape.draw();
  }
}

class RedShapeDecorator extends ShapeDecorator {

  public RedShapeDecorator(Shape shape) {
    super(shape);
  }

  @Override
  public void draw() {
//    System.out.println("draw red");
    super.draw();// 核心功能
    setBorder();
  }

  public void setBorder() {
    System.out.println("Red Border has been set.");
  }
}

class YellowShapeDecorator extends ShapeDecorator {

  public YellowShapeDecorator(Shape shape) {
    super(shape);
  }

  @Override
  public void draw() {
    super.draw();
    drawYellow();
  }

  public void drawYellow() {
    System.out.println("Yellow");
  }
}



