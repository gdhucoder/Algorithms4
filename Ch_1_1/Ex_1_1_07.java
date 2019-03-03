package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * Created by HuGuodong on 2019/2/17.
 */

public class Ex_1_1_07 {

  public static void main(String[] args) {
//    1.1.7 Give the value printed by each of the following code fragments:

  }

  @Test
  public void testA() {
    double t = 9.0;
    while (Math.abs(t - 9.0 / t) > .001)
      t = (9.0 / t + t) / 2.0;
    StdOut.printf("%.5f\n", t);
  }

  @Test
  public void testB(){
    int sum = 0;
    for (int i = 1; i < 1000; i++) {
      for (int j = 0; j < i; j++) {
        sum++;
      }
    }
    StdOut.println(sum);
  }

  @Test
  public void testC(){
    int sum = 0;
    for (int i = 1; i < 1000; i*=2) {
      for (int j = 0; j < i; j++) {
        sum++;
      }
    }
    StdOut.println(sum);
  }


}
