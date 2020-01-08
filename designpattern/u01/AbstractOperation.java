package designpattern.u01;

/**
 * Created by HuGuodong on 2019/11/9.
 */
public abstract class AbstractOperation {

  private double a;
  private double b;

  public double getA() {
    return a;
  }

  public void setA(double a) {
    this.a = a;
  }

  public double getB() {
    return b;
  }

  public void setB(double b) {
    this.b = b;
  }

  public abstract double getResult();
}

class OperationAdd extends AbstractOperation {

  @Override
  public double getResult() {
    return getA() + getB();
  }
}

class OperationSub extends AbstractOperation {

  @Override
  public double getResult() {
    return getA() - getB();
  }
}

class OperationMult extends AbstractOperation {

  @Override
  public double getResult() {
    return getA() * getB();
  }
}

class OperationDiv extends AbstractOperation {

  @Override
  public double getResult() {
    if (getB() == 0) {
      throw new IllegalArgumentException("b can not be zero.");
    }
    return getA() / getB();
  }
}