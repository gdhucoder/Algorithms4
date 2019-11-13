package designpattern.u5;

/**
 * Created by HuGuodong on 2019/11/13.
 */
public class TestInheritance {

  public static void main(String[] args) {
    TestInheritance ts = new TestInheritance();
    ts.sayHi();
    ts.print();
  }

  class A extends Foo {

    @Override
    void print() {
      super.print();
    }
  }

  class B extends AnotherFoo {

    @Override
    void sayHi() {
      super.sayHi();
    }
  }

  public void print() {
    new A().print();
  }

  public void sayHi() {
    new B().sayHi();
  }

}

class Foo {

  void print() {
    System.out.println("I am foo.");
  }
}

class AnotherFoo {

  void sayHi() {
    System.out.println("I am another foo!");
  }
}