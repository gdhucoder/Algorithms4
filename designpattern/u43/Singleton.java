package designpattern.u43;

/**
 * Created by HuGuodong on 2/10/20.
 */
public class Singleton {

  private static Singleton instance = new Singleton();

  private Singleton() {}

  public static Singleton getInstance() {
    return instance;
  }

}
