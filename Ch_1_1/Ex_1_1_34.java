package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
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
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  // using only a fixed number of variables
  public void printMaxMinValues(double[] x) {
    double[] a = ArrayGenerator.genRandomDoules(10, 0, 1);
    PrintUtil.show(a);
    double min = min(a);
    double max = max(a);
    StdOut.printf("max=%f, min=%f\n", max, min);
  }

  // Print the median of the numbers.
  // using only a fixed number of variables
  public void printMedian(double[] a) {
    Arrays.sort(a);
    StdOut.println("after sort:");
    StdOut.println(Arrays.toString(a));
    double median = -1.0;
    int N = a.length;
    if (a.length % 2 == 0) {
      median = (a[N / 2] + a[N / 2 - 1]) / 2;
    }else{
      median = a[N/2];
    }
    StdOut.printf("median is %f\n", median);
  }

  //  Print the k th smallest value, for k less than 100.
  public void printKthSmallestVal(double[] a){

  }

  //  Print the sum of the squares of the numbers.
  public void printSumOfSquares(double[] a){
    double sum = 0.0;
    for (int i = 0; i < a.length; i++) {
      sum += Math.pow(a[i],2);
    }
    StdOut.printf("sum = %f\n", sum);
  }


  @Test
  public void test() {
    printMaxMinValues(null);
    double[] a = ArrayGenerator.genRandomDoules(9, 0, 1);
    printMedian(a);
//    [0.03245387822274215, 0.1972163318519624, 0.24457389024306286, 0.3193148513170959, 0.3322904690496359, 0.5568135478384075, 0.6432952674018141, 0.6727822471464756, 0.7323726023930617]
//    median is 0.332290

  }

  public static void main(String[] args) {

  }

}
