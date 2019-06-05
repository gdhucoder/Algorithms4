package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;
import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/6/5.
 */

public class Ex_1_1_34 {


  public static double min(double[] a) {
    double min = a[0];
    for (int i = 1; i < a.length; i++) {
      if (a[i] < min) {
        min = a[i];
      }
    }
    return min;
  }

  public static double max(double[] a) {
    double max = a[0];
    for (int i = 1; i < a.length; i++) {
      if(a[i]>max){
        max = a[i];
      }
    }
    return max;
  }

  public void printMaxMinValues(double[] x) {
    double[] a = ArrayGenerator.genRandomDoules(10,0,1);
    PrintUtil.show(a);
    double min = min(a);
    double max = max(a);
    StdOut.printf("max=%f, min=%f\n", max, min);
  }

  @Test
  public void test(){
    printMaxMinValues(null);
  }

  public static void main(String[] args) {

  }

}
