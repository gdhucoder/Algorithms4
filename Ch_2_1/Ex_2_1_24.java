package Ch_2_1;

import static tools.ArrayGenerator.randomIntArray;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.Arrays;

/**
 * Created by HuGuodong on 2018/11/6.
 */

public class Ex_2_1_24 {

  static class InsertionSortWithoutSentinel extends _Sort{
    @Override
    public void sort(Comparable[] a) {
      Stopwatch timer = new Stopwatch();
      for(int i=1; i<a.length; i++){
        for(int j=i; j>0 && less(a[j],a[j-1]); j--){
          exch(a,j,j-1);
        }
      }
      assert isSorted(a);
      StdOut.println("未使用哨兵：" + timer.elapsedTime());

    }
  }

  static class InsertionSortWithSentinel extends _Sort{
    @Override
    public void sort(Comparable[] a) {
      Stopwatch timer = new Stopwatch();
      // 将最小的元素放到最左边的位置
      int n = a.length;
      for(int i=n-1; i>0; i--){
        if(less(a[i], a[i-1])){
          exch(a, i, i-1);
        }
      }

      //
      for(int i=2; i<a.length; i++){
        for(int j=i; less(a[j],a[j-1]); j--){ // a[0] 已经是最小元素了，a[1] 恒大于 a[0]
          exch(a,j,j-1);
        }
      }

      assert isSorted(a);
      StdOut.println("使用哨兵："+ timer.elapsedTime());
    }
  }

  public static void main(String[] args) {
    int N = 100000;
    Integer[] a = randomIntArray(N);
    InsertionSortWithoutSentinel insert = new InsertionSortWithoutSentinel();
    insert.sort(a);
//    insert.show(a);

    a= randomIntArray(N);
    InsertionSortWithSentinel sentinel = new InsertionSortWithSentinel();
    sentinel.sort(a);
//    sentinel.show(a);

//    未使用哨兵：15.239
//    使用哨兵：14.562
  }

}
