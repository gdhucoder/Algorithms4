package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/2/17.
 */

public class Ex_1_1_09 {

  public static void main(String[] args) {
//    1.1.9 Write a code fragment that puts the binary representation of a positive integer N into a String s.

    System.out.println(decimalToBinary(-1));

    System.out.println(-1 >>> 1);
    System.out.println(-1 >> 1);
    test();

    int N = 1024;
    String s = "";
    while (N > 0) {
      s = N % 2 + s;
      N /= 2;
    }
    StdOut.println(toBinaryStringSolution1(1024));
  }

  public static String toBinaryStringSolution1(int N) {
    String s = "";
    while (N > 0) {
      s = N % 2 + s;
      N /= 2;
    }
    return s;
  }

  public static String toBinaryStringSolution2(int N){
    return "";
  }

  public static void test() {
    int a = 9;
    System.out.println(Integer.toBinaryString(a));
    // 1001 -> 10
    System.out.println(a >> 2); // 10
    a = 9;
    System.out.println(a >> 2); // 10

    //
    int b = -1;
    // 11111111111111111111111111111111
    System.out.println(Integer.toBinaryString(b));
    System.out.println(Integer.toBinaryString(b >> 2));
    System.out.println(b >> 2);
    // 00111111111111111111111111111111
    System.out.println(Integer.toBinaryString(b >>> 2));
    System.out.println(b >>> 2);

    System.out.println(10>>1);
    System.out.println(10>>2);
    System.out.println(10>>3);
    System.out.println(10>>4);

    System.out.println(10>>1 & 1);
    System.out.println(10>>2 & 1);
    System.out.println(10>>3 & 1);
    System.out.println(10>>4 & 1);

  }

  public static String decimalToBinary(int n) {
    String resultString = "";
    for (int i = 31; i >= 0; i--)
      resultString = resultString + (n >>> i & 1);
    return resultString;
  }
}
