package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/2/18.
 */

public class Ex_1_1_12 {

  public static void main(String[] args) {
    int[] a = new int[10];
    for (int i = 0; i < 10; i++)
      a[i] = 9 - i;
    for (int i = 0; i < 10; i++)
      a[i] = a[a[i]];
    for (int i = 0; i < 10; i++)
      StdOut.print(a[i]+" ");
  }
//  0 1 2 3 4 4 3 2 1 0
}
