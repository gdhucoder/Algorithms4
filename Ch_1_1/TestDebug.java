package Ch_1_1;

/**
 * Created by HuGuodong on 2019/1/28.
 */

public class TestDebug {

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      System.out.println(i + show() + show1() +show()+show());
    }

    System.out.println(100);
  }

  public static String show(){
    return "haha";
  }

  private static String show1(){
    String s = new String("hahah");
    return show();
  }


}
