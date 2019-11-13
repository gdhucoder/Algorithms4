package geekbang.ALGO.u16;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import org.junit.Test;
import tools.ArrayGenerator;

/**
 * Created by HuGuodong on 2019/4/23.
 */

public class BSearchVariant2 {


  /**
   * 查找最后一个等于key的元素的位置
   */
  public static int bsearch(int[] a, int key) {
    int low = 0;
    int hi = a.length - 1;
    while (low <= hi) {
//      将mid = lo + (hi - lo) /2，将除法优化成移位运算时，得注意运算符的优先级，千万不能写成这样：mid = lo + (hi - lo) >> 1
      int mid = low + ((hi - low) >> 1); // >> 的优先级小于 + - 号
      if (key > a[mid]) {
        low = mid + 1;
      } else if (key < a[mid]) {
        hi = mid - 1;
      } else if (mid == a.length -1 || (a[mid + 1] != key)) {
        return mid;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  @Test
  public void test1() {
    int[] a = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    int key = 8;
    int pos = bsearch(a, key);
    assert pos == 7;
    StdOut.printf("pos = %d\n", pos);
    a = ArrayGenerator.ascInts(1, 1, 10);
//    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    StdOut.println(Arrays.toString(a));
    key = 1;
    pos = bsearch(a, key);
    assert pos == 9;
    StdOut.printf("pos = %d\n", pos);
//    pos = 7
//    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
//    pos = 9
  }

  public static void main(String[] args) {
    int a = 5 + (7) >> 1;
    assert a == 6;
    StdOut.println(a);

  }


}
