package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/3/3.
 */

public class Ex_1_1_20 {
  public static double ln(int n){
    if(n==1) return 0;
    return ln(n-1)+Math.log(n);
  }

  public static void main(String[] args) {
    int N = 5;
    double ans = ln(N);
    StdOut.printf("ln(%d!) = %f\n", N, ans);
    double ret = 0.0;
    for (int i = 1; i <= N; i++) {
      ret+=Math.log(i);
    }
    System.out.println("check: " + ret);
//    ln(5!) = 4.787492
//    check: 4.787491742782046
  }
}
