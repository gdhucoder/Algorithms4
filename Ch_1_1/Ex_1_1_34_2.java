package Ch_1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/6/11.
 */

public class Ex_1_1_34_2 {

  /**
   * Print the percentage of numbers greater than the average
   */

  public void percentOfNumberGreatetThanAvg() {

  }

  /**
   * Print the percentage of numbers greater than the average
   * @param args
   */
  public static void main(String[] args) {
    double sum = 0.0;
    int cnt = 0;
    int SIZE_LIMIT = 10;
    double[] a = new double[SIZE_LIMIT];
    for (int i = 0; i < SIZE_LIMIT; i++) {
      a[i] = Double.MIN_VALUE;
    }

    // 计算平均值
    while (!StdIn.isEmpty()) {
      double num = StdIn.readDouble();
      sum += num;
      a[cnt] = num;
      cnt++;
    }
    double avg = sum / cnt;
    StdOut.printf("avg is %.2f\n", avg);

    // 大于平均数的元素个数
    int gtAvgCnt = 0;
    for (int i = 0; i < cnt; i++) {
      if (a[i] > Double.MIN_VALUE && a[i] > avg) {
        gtAvgCnt++;
      }
    }

    // 计算百分比
    double percent = (double) gtAvgCnt / cnt;
    StdOut.printf("percent is %.2f%%\n", percent * 100);
//    1
//    2 3 4 5
//    ^D
//    avg is 3.00
//    percent is 40.00%
  }
}
