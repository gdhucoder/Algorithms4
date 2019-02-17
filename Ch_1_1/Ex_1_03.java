package Ch_1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/2/17.
 */

public class Ex_1_03 {

  public static void main(String[] args) {

    int num1 = StdIn.readInt();
    int num2 = StdIn.readInt();
    int num3 = StdIn.readInt();

    if (num1 == num2 && num2 == num3)
      StdOut.println("equal");
    else
      StdOut.println("not equal");

  }

}
