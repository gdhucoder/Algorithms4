package Ch_5_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import java.util.ArrayList;
import java.util.List;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/2/19.
 */

public class Ex_5_1_14 {

  public static class Record {

    public String val;
    private int[] key;

    public Record(int val) {
      this.val = "" + val;
      int length = digit(val);
      key = new int[length];

      for (int i = length - 1; i >= 0; i--, val /= 10) {
        key[i] = val % 10;
      }
    }

    private int digit(int val) {
      int digit = 0;
      do {
        val /= 10;
        digit++;
      } while (val != 0);
      return digit;
    }

    @Override
    public String toString() {
      return this.val;
    }
  }

  public static class Quick3String {

    public static void sort(Record[] a) {

      sort(a, 0, a.length - 1, 0);

    }

    private static int numAt(int[] arr, int d) {
      if (d < arr.length) {
        return arr[d];
      } else {
        return Integer.MIN_VALUE;
      }
    }

    public static void sort(Record[] a, int lo, int hi, int d) {
      if (hi <= lo)
        return;
      int lt = lo, gt = hi;
      int i = lo + 1;
      int t = Integer.MIN_VALUE;
      Record temp = new Record(Integer.parseInt(a[lo].val));
      while (i <= gt) {
        t = numAt(a[i].key, d);
        int cmp = compare(a[i], temp, d);
        if (cmp < 0)
          exch(a, lt++, i++);
        else if (cmp > 0)
          exch(a, i, gt--);
        else
          i++;
      }
      sort(a, lo, lt - 1, d);
      if (t != Integer.MIN_VALUE)
        sort(a, lt, gt, d + 1);
      sort(a, gt + 1, hi, d);
    }

    private static int compare(Record a, Record b, int d) {
      if (a.key.length > b.key.length) {
        return 1;
      } else if (a.key.length == b.key.length) {
        return numAt(a.key, d) > numAt(b.key, d) ? 1 :
            numAt(a.key, d) == numAt(b.key, d) ? 0 : -1;
      } else {
        return -1;
      }
    }

    private static void exch(Object[] a, int i, int j) {
      Object temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }

  public static Record[] genArr(int N){
    Record[] arr = new Record[N];
    for (int i = 0; i < N; i++) {
      arr[i] = new Record(StdRandom.uniform(0, 100001));
    }
    return arr;
  }

  public static void main(String[] args) {
    Record[] a = genArr(20);
    PrintUtil.show(a);
    Quick3String.sort(a);
    PrintUtil.show(a);

//    75153	11616	28194	94764	67693	18051	78869	8701	65086	81554	83618	66254	2487	97673	59446	8172	55202	60582	84908	84373
//    2487	8172	8701	11616	18051	28194	55202	59446	60582	65086	66254	67693	75153	78869	81554	83618	84373	84908	94764	97673
  }


}
