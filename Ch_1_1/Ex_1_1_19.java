package Ch_1_1;

import static Ch_1_1.Ex_1_1_19.Fibonacci.F;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/3/3.
 */

public class Ex_1_1_19 {

  /**
   * 重复计算F(N)
   */
  public static class Fibonacci_Simple {

    public static long F(int N) {
      if (N == 0)
        return 0;
      if (N == 1)
        return 1;
      return F(N - 1) + F(N - 2);
    }
  }


  /**
   * 改进Fibonacci的F(N)
   * 将结果保存在数组中。
   */
  public static class Fibonacci {

    private static long[] result = new long[100];

    public static long F(int N) {
      if (N == 0)
        return 0;
      if (N == 1)
        return 1;
      if (result[N] != 0) {
        return result[N];
      } else {
        result[N] = F(N - 1) + F(N - 2);
      }
      return result[N];
    }
  }

  public static void main(String[] args) {

    // for number 100, the numbers are so big that 64 bit long variable overflows
    for (int N = 0; N < 100; N++) {
      StdOut.println(N + " " + F(N));
    }

    // 算到44多就很慢了
    for (int N = 0; N < 100; N++) {
      StdOut.println(N + " " + Fibonacci_Simple.F(N));
    }
  }

}
