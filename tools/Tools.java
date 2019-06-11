package tools;

import java.math.BigDecimal;
import java.math.BigInteger;

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

  public static void main(String[] args) {
    double val = 265.335;
    String out1 = BigDecimal.valueOf(val).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    System.out.println(out1);
    // 行为不可测
    String out2 = (new BigDecimal(val)).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    System.out.println(out2);
    String out3 = new BigDecimal(val).toPlainString();
    System.out.println(out3);
    String out4 = BigDecimal.valueOf(val).toPlainString();
    System.out.println(out4);
//    265.34
//    265.33
//    265.33499999999997953636921010911464691162109375
//    265.335
  }
}
