package Ch_2_1;

import static tools.ArrayGenerator.randomIntArray;

import Ch_2_1.Ex_2_1_24.InsertionSortWithoutSentinel;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HuGuodong on 2018/11/6.
 */

public class Ex_2_1_25 {

  static class InsertionX extends _Sort{

    @Override
    public void sort(Comparable[] a) {

      Stopwatch timer = new Stopwatch();

      int n = a.length;
      // put smallest element in position to serve as sentinel
      int exchanges = 0;
      for(int i=n-1; i>0; i--){
        if(less(a[i], a[i-1])){
          exch(a, i, i-1);
          exchanges++;
        }
      }

      if(exchanges==0) return;

      for(int i=2; i<n; i++){
        int count = 0;
        Comparable v = a[i];
//        for(int j=i; j>0; j--){
//
//          if(less(v, a[j-1])){
//            a[j] = a[j-1];
//            count++;
//          }
//        }
//        if(count>0){
//          a[i-count]  = v;
//        }
        int j = i;
        while (less(v, a[j-1])){ // 不使用exch减少数组的访问次数
          a[j] = a[j-1]; // 将大于v的元素移动到对应的位置
          j--;
        }
        a[j] = v; // 将v移动到对应的位置。
      }

      assert isSorted(a);
      StdOut.println("不使用交换：" + timer.elapsedTime());
    }
  }

  public static void main(String[] args) {
    int N = 100000;
    Integer[] a = randomIntArray(N);

    InsertionX insertionX = new InsertionX();
    insertionX.sort(a);
    a = randomIntArray(N);
    InsertionSortWithoutSentinel ordinary = new InsertionSortWithoutSentinel();
    ordinary.sort(a);


//    insertAtFirst.show(a);
//
//    a = randomIntArray(N);
//    InsertionSortWithSentinel sentinel = new InsertionSortWithSentinel();
//    sentinel.sort(a);

//    不使用交换：13.172
//    未使用哨兵：15.174
  }

}
