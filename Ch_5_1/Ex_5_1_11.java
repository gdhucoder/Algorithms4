package Ch_5_1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/2/1.
 */

public class Ex_5_1_11 {

  public static class _queMSD {

    private static final int R = 26;

    private static int charAt(String s, int d) {
      if (d < s.length()) {
        return _Alphabet.LOWERCASE.toIndex(s.charAt(d));
      } else {
        return -1;
      }
    }

    private static void sort(String[] a, int lo, int hi, int d) {

      if (hi <= lo) {
        return;
      }
      StdOut.printf("sort(%2d, %2d, %2d)", lo, hi,d);
      PrintUtil.show(a);

      Queue<String>[] bins = new Queue[R + 1];
      for (int r = 0; r < bins.length; r++) {
        bins[r] = new Queue<>();
      }

      // put items in the q
      for (int i = lo; i <= hi; i++) {
        int pos = charAt(a[i], d);
        bins[pos+1].enqueue(a[i]);
      }

      // sort sub list ?
      for (int r = 0, i = lo; r < bins.length; r++) {
        if(!bins[r].isEmpty()){
          for(String s : bins[r]){
            a[i++] = s;
          }
        }
      }


      for (int r = 1, i = lo; r < bins.length; r++) {
        int temp_lo = i;
        boolean flag = false;
        while (!bins[r].isEmpty()) {
          bins[r].dequeue();
          flag = true;
          i++;
        }
        int temp_hi = i-1;
        if(flag){
          sort(a, temp_lo, temp_hi, d+1);
        }
      }

    }

    public static void sort(String[] a) {
      int N = a.length;
      int d = 0;
      sort(a, 0, N - 1, d);
    }
  }

  @Test
  public void testSort_1() {
    String[] a = "she, shells, seashells, by, the, sea, shore, the, shells, she, shells, are, surely, seashells"
        .replaceAll(" ", "").split(",");
    _queMSD.sort(a);
//    sort( 0, 13,  0)she	shells	seashells	by	the	sea	shore	the	shells	she	shells	are	surely	seashells
//    sort( 2, 11,  1)are	by	she	shells	seashells	sea	shore	shells	she	shells	surely	seashells	the	the
//    sort( 2,  4,  2)are	by	seashells	sea	seashells	she	shells	shore	shells	she	shells	surely	the	the
//    sort( 2,  4,  3)are	by	seashells	sea	seashells	she	shells	shore	shells	she	shells	surely	the	the
//    sort( 2,  3,  4)are	by	sea	seashells	seashells	she	shells	shore	shells	she	shells	surely	the	the
//    sort( 5, 10,  2)are	by	sea	seashells	seashells	she	shells	shore	shells	she	shells	surely	the	the
//    sort( 5,  9,  3)are	by	sea	seashells	seashells	she	shells	shells	she	shells	shore	surely	the	the
//    sort( 5,  7,  4)are	by	sea	seashells	seashells	she	she	shells	shells	shells	shore	surely	the	the
//    sort(12, 13,  1)are	by	sea	seashells	seashells	she	she	shells	shells	shells	shore	surely	the	the
//    sort(12, 13,  2)are	by	sea	seashells	seashells	she	she	shells	shells	shells	shore	surely	the	the
//    sort(12, 13,  3)are	by	sea	seashells	seashells	she	she	shells	shells	shells	shore	surely	the	the

  }

  public static void main(String[] args) {
    String[] a = {"zzzz", "a", "acbd", "aca", "abe"};
    _queMSD.sort(a);
    PrintUtil.show(a);
  }
}
