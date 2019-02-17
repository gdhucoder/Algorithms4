package Ch_1_1;

/**
 * Created by HuGuodong on 2019/2/17.
 */

public class Ex_1_04 {

  public static void main(String[] args) {
    int a = 0;
    int b = 2;
    int c = 100;

    // a.Java 中没有 then 关键字
//    if(a>b) then c = 0 ;

    // b. 没有括号
//    if a > b { c = 0;}

    // 正确
    if (a > b) c = 0;

    // 没有 ;
//    if (a > b) c = 0 else b = 0;
  }
}
