package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2019/4/13.
 */

public class Ex_1_1_27 {

  public static int count;

  public static double binomial(int N, int k, double p) {
//    printIndent(count);
//    StdOut.printf("% d, %d\n", N, k);
    count++;
    if ((N == 0) && (k == 0))
      return 1.0;
    if (N < 0 || k < 0)
      return 0.0;
    return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
  }

  public static double binomial_modified(int N, int k, double p) {
    double[][] f = new double[N + 1][k + 1];

    // f(0,0,p)
    f[0][0] = 1.0;

    //f(N,0,p)
    for (int i = 1; i < N + 1; i++) {
      // 递推公式
      f[i][0] = (1.0 - p) * f[i - 1][0] + 0.0;
    }

    // f(N,k,p)
    for (int i = 1; i < N + 1; i++) {
      for (int j = 1; j < k + 1; j++) {

        // 递推公式
        f[i][j] = (1.0 - p) * f[i - 1][j] + p * f[i - 1][j - 1];
      }
    }

    return f[N][k];
  }

//  public static double binomial_modified(int N, int k, double p) {
//    if(N < 0 || k < 0) return 0.0;
//
//    // 分配数组容量
//    double[][] container = new double[N + 1][];
//    for(int i = 0; i < N + 1; i++)
//      container[i] = new double[k + 1];
//
//    // (0, 0)
//    container[0][0] = 1.0;
//
//    // (N, 0)
//    for(int i = 1; i < N + 1; i++)
//      container[i][0] = (1.0 - p) * container[i - 1][0];
//    // (0, k)
//    for(int i = 1; i < k + 1; i++)
//      container[0][i] = 0.0;
//    // (N, k)
//    for(int i = 1; i < N + 1; i++)
//      for(int j = 1; j < k + 1; j++)
//        container[i][j] = (1.0 - p) * container[i - 1][j] + p * container[i - 1][j - 1];
//    return container[N][k];
//  }

  private static void printIndent(int n) {
    StdOut.printf("level %d: ", n);
    for (int i = 0; i < n; i++) {
      StdOut.print("..");
    }
  }

  /**
   * 测试
   */
  public static void recursiveTest() {
    for (int N = 1; N <= 10; N++) {
      for (int k = 0; k <= N; k++) {
        double f1 = binomial(N, k, 0.25);
        double f2 = binomial_modified(N, k, 0.25);

        StdOut.printf("%3f, %3f \n", f1, f2);

        int recursiveCount = count;
        int maxLimit = (int) (Math.pow(2, N + 2) - 1);
        StdOut.printf("recursiveCount: %d\n", recursiveCount);
        StdOut.printf("maxLimit: %d\n", maxLimit);
        count = 0;
      }
    }
  }


  public static void main(String[] args) {
    recursiveTest();
    double f = binomial_modified(100, 50, 0.5);
    StdOut.printf("f(100,50,0.5) = %3f\n", f);
  }
}
