package tools;

import java.math.BigDecimal;

/**
 * Created by HuGuodong on 2019/6/12.
 */

public class Tools {


  /**
   * changeDecimalPrecision
   * @param a
   * @param scale
   */
  public static void changeDecimalPrecision(double[] a, int scale) {
    BigDecimal val;
    for (int i = 0; i < a.length; i++) {
      val = new BigDecimal(String.valueOf(a[i])).setScale(scale, BigDecimal.ROUND_HALF_UP);
      a[i] = val.doubleValue();
    }
  }
}
