package Ch_1_1;

/**
 * Created by HuGuodong on 2019/6/12.
 */

public class RoundingCounterExample {

  static double roundOff(double x, int position) {
    double a = x;
    double temp = Math.pow(10.0, position);
    a *= temp;
    a = Math.round(a);
    return (a / (double) temp);
  }

  public static void main(String[] args) {
    double a = roundOff(0.0009434, 3);
    System.out.println("a=" + a + " (a % .001)=" + (a % 0.001));
    int count = 0, errors = 0;
    for (double x = 0.0; x < 1; x += 0.0001) {
      count++;
      double d = x;
      int scale = 2;
      double factor = Math.pow(10, scale);
      d = Math.round(d * factor) / factor;
      System.out.println(d + " " + x);
      if ((d % 0.01) != 0.0) {
        System.out.println(d + " " + (d % 0.01));
        errors++;
      }
    }
    System.out.println(count + " trials " + errors + " errors");
  }
}
