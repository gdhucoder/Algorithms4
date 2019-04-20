package geekbang.u13;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/4/20.
 */

public class CountingSort {

  public static void sort(int[] a) {

    int N = a.length;

    int max = a[0];
    for (int i = 1; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }

    int[] count = new int[max + 1];

    // compute frequency
    for (int i = 0; i < N; i++) {
      count[a[i]]++;
    }

    // transform counts into indices
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    StdOut.println("count: " + Arrays.toString(count));

    int[] res = new int[N];

    // Build the output character array
    // To make it stable we are operating in reverse order

//    for (int i = 0; i < N; i++) { // unstable
//      count[a[i]]--;
//      res[count[a[i]]] = a[i];
//    }

    for (int i = N - 1; i >= 0; i--) {
      res[count[a[i]] - 1] = a[i];
      count[a[i]]--;
    }

    // copy back
    for (int i = 0; i < N; i++) {
      a[i] = res[i];
    }

    StdOut.println("sort: " + Arrays.toString(a));

  }

  // 适用于键是比较小的整数

  // 例如可以用在字符串排序算法中(ALG4)，或者给全省几十万高考生成绩排序，都可以使用counting sort
  // 线性时间复杂度
  public static void main(String[] args) {
    int[] a = {2, 5, 3, 0, 2, 3, 0, 3};
    sort(a);
    StdOut.println("after sort");
    StdOut.println(Arrays.toString(a));
//    count: [2, 2, 4, 7, 7, 8]
//    sort: [0, 0, 2, 2, 3, 3, 3, 5]
//    after sort
//    [0, 0, 2, 2, 3, 3, 3, 5]
  }
}
 