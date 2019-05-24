package interview.base;

/**
 * Created by HuGuodong on 2019/5/23.
 */

/**
 * 子类初始化顺序
 */
class Base{
  // 1
  static {
    System.out.println("Base static block");
  }

  // 4
  public Base(){
    System.out.println("Base constructor");
  }

  // 3
  {
    System.out.println("Base block");
  }
}

public class TestDerived extends Base{

  // 6
  public TestDerived(){
    // 当有父类时，在实例化对象时会先执行父类的构造函数，然后执行子类的构造函数。
    System.out.println("TestDerived constructor");
  }

  // 2
  static {
    System.out.println("Derived static block");
  }

  // 5
  {
    System.out.println("Derived Block");
  }

  public static void main(String[] args) {
    new TestDerived();
  }

}
