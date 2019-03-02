package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/3/3.
 */

public class Ex_1_1_16 {
  private static int level;
  public static String exR1(int n){
    PrintUtil.printPlaceholder('-', level++);
    StdOut.printf("exR1(%d)\n", n);
    if (n<=0) return "";
    return exR1(n-3) + n + exR1(n-2) + n;
  }

  public static void main(String[] args) {
    String ans = exR1(6);
    System.out.println(ans);
//    exR1(6)
//    -exR1(3)
//    --exR1(0)
//    ---exR1(1)
//    ----exR1(-2)
//    -----exR1(-1)
//    ------exR1(4)
//    -------exR1(1)
//    --------exR1(-2)
//    ---------exR1(-1)
//    ----------exR1(2)
//    -----------exR1(-1)
//    ------------exR1(0)
//    311361142246
  }
}
