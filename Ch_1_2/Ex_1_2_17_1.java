package Ch_1_2;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * Some test Created by HuGuodong on 2019/6/26.
 */

public class Ex_1_2_17_1 {

  @Test
  public void test1() {
    StdOut.println(Long.toBinaryString((-1L >>> 31)));
    StdOut.println((-1L >>> 31));
    StdOut.println((1L >>> 31) + ": " + Long.toBinaryString(1L >>> 31));
    StdOut.println(Long.MIN_VALUE + Long.MIN_VALUE);
    long res = Math.addExact(Long.MIN_VALUE, Long.MIN_VALUE);
  }

  public static void main(String[] args) {
    // Bitwise exclusive OR
    // outputs true only when inputs differ (one is true, the other is false).
    System.out.println(1 ^ 1);
    System.out.println(-1 ^ -1);
    // Bitwise inclusive OR
    // logical value "true" when at least one of the predicates is true.
    System.out.println(1 | 1);
    // Bitwise AND
    System.out.println(1 & 1);

    StdOut.println(Integer.toBinaryString(1));
    StdOut.println(Integer.toBinaryString(-1));
    StdOut.println((1 ^ -1) + " " + Integer.toBinaryString(1 ^ -1));
    StdOut.println((-1 & -1) + " " + Integer.toBinaryString(-1 & -1));
  }
}
