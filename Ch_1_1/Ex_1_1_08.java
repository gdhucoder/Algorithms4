package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/2/17.
 */

public class Ex_1_1_08 {

  public static void main(String[] args) {
//    1.1.8 What do each of the following print?
// a. System.out.println('b');
// b. System.out.println('b' + 'c');
// c. System.out.println((char) ('a' + 4));
//    Explain each outcome.

    // char to String
    System.out.println('b');

    // b char 类型 转换为 98， c 转换为99
    System.out.println('b'+'c');

    // e : 'a' char to int , 97, 97+4=111, 111 to char = e
    System.out.println((char)('a'+4));
  }
}
