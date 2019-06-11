package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/6/11.
 */

public class Ex_1_1_34_1 {

  /**
   * 使用冒泡排序 K 次。需要保存标准输入的所有值
   * require saving all the values from standard input (in an array, say)
   * @param a
   * @param k
   */
  public static void KLargest_UsingBubbleSort(int[] a, int k) {
    if(k<1 || k>a.length){
      throw new IllegalArgumentException("k must be >=1 and <=a.length");
    }
    for (int i = 0; i < k; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[j] > a[i]) {
          swap(a, i, j);
        }
      }
    }
    StdOut.println(a[k-1]);
  }


  public static void KLargest(){

  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    int[] a = {5, 3, 2, 1, 4};
    KLargest_UsingBubbleSort(a, 5);
  }


}
