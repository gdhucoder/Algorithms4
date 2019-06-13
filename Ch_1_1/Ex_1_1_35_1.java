package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import java.math.BigDecimal;
import tools.PrintUtil;

/**
 * 保留小数精度
 * Created by HuGuodong on 2019/6/12.
 */

public class Ex_1_1_35_1 {

  /**
   * 内循环中每次新建对象，速度慢
   * @param a
   * @param scale
   */
  public static void changePrecision(double[] a, int scale) {
    for (int i = 0; i < a.length; i++) {
      BigDecimal val = new BigDecimal(String.valueOf(a[i]))
          .setScale(scale, BigDecimal.ROUND_HALF_UP);
      a[i] = val.doubleValue();
    }
  }

  /**
   * 这种方式 val 没有新建对象，只是改变了引用的值
   * @param a
   * @param scale
   */
  public static void changePrecision2(double[] a, int scale) {
    BigDecimal val;
    for (int i = 0; i < a.length; i++) {
      val = new BigDecimal(String.valueOf(a[i])).setScale(scale, BigDecimal.ROUND_HALF_UP);
      a[i] = val.doubleValue();
    }
  }

  public void testDouble(){
    double a = 10d;
    System.out.println(10d);
  }

  public static void main(String[] args) {
    double[] a = new double[10];

    for (int i = 0; i < a.length; i++) {
      a[i] = StdRandom.uniform();
      StdOut.println(a[i]);
    }
    Stopwatch timer1 = new Stopwatch();
    for (int i = 0; i < 10000; i++) {
      changePrecision(a, 3);
    }
    StdOut.println(timer1.elapsedTime()); // 0.103 s
    Stopwatch timer2 = new Stopwatch();
    for (int i = 0; i < 10000; i++) {
      changePrecision2(a, 3);
    }
    StdOut.println(timer2.elapsedTime()); // 0.047 s

    PrintUtil.show(a);

  }
}
