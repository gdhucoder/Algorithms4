package Ch_5_1;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/2/19.
 */

public class Ex_5_1_14_1 {

//  {-1}
//
//  {100,2000,3000}
//
//  {101,2000,3000}

  public static class Record {

    public String val;
    private int[] key;

    public Record(String val) {
      this.val = val;
      String[] arr = val.replaceAll(" ", "").split(",");
      int length = arr.length;
      key = new int[length];
      for (int i = 0; i < key.length; i++) {
        key[i] = Integer.parseInt(arr[i]);
      }
      
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
      int v = numAt(a[lo].key, d);
      int t = Integer.MIN_VALUE;
      while (i <= gt) {
        t = numAt(a[i].key, d);
        if (t < v)
          exch(a, lt++, i++);
        else if (t > v)
          exch(a, i, gt--);
        else
          i++;
      }
      sort(a, lo, lt - 1, d);
      if (v != Integer.MIN_VALUE)
        sort(a, lt, gt, d + 1);
      sort(a, gt + 1, hi, d);
    }

    private static void exch(Object[] a, int i, int j) {
      Object temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }

//  public static Record[] genArr(int M){
//    Record[] r = new Record[M];
//    for (int i = 0; i < M; i++) {
//      r[i] = new Record()
//    }
//  }

  public static void main(String[] args) {
    Record[] r = new Record[3];
    r[0] = new Record("-1");
    r[1] = new Record("101, 2000, 5001");
    r[2] = new Record("101, 2000, 5000");
    Quick3String.sort(r);
    PrintUtil.show(r);
  }

}
