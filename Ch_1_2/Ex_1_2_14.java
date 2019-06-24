package Ch_1_2;

import Ch_1_2.Ex_1_2_13._Transaction;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/6/24.
 */

public class Ex_1_2_14 {

  public static void main(String[] args) {
    _Transaction t1 = new _Transaction("huguodong 2019/06/22 100.12");
    _Transaction t2 = new _Transaction("huguodong 2019/06/22 100.12");
    boolean eq = t1.equals(t2);
    StdOut.println(eq); // true

  }
}
