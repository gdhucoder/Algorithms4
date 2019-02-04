package Ch_5_1;

import static Ch_5_1.Ex_5_1_04._Quick3String.show;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/1/18.
 */

public class _MSD {

  private static int R = 256;
  private static final int M = 15; // cutoff for small subarrays
  private static String[] aux; // auxiliary array for distribution

  private static int charAt(String s, int d) {
    if (d < s.length())
      return s.charAt(d);
    else
      return -1;
  }

  public static void sort(String[] a) {
    int N = a.length;
    aux = new String[N];
    sort(a, 0, N - 1, 0);
  }

  private static void sort(String[] a, int lo, int hi, int d) {
    if(hi<=lo){
      return;
    }

    StdOut.printf("sort(%2d, %2d, %2d): ", lo, hi, d);
    PrintUtil.show(a);

    int[] count = new int[R + 2];
    for (int i = lo; i <= hi; i++)
      count[charAt(a[i], d) + 2]++;

    for (int r = 0; r < R + 1; r++) {
      count[r + 1] += count[r];
    }

    for (int i = lo; i <= hi; i++) {
      aux[count[charAt(a[i], d) + 1]++] = a[i];
    }

    for (int i = lo; i <= hi; i++) {
      a[i] = aux[i - lo];
    }

    for (int r = 0; r < R; r++) {
      sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
    }

  }



  @Test
  public void test1(){
    String[] a = "she, sells, seashells, seashore".replaceAll(" ","").split(",");
    sort(a);
  }

  public static void main(String[] args) {

    String str = "she, shells, seashells, by, the, sea, shore, the, shells, she, shells, are, surely, seashells";
    String[] strings = str.replaceAll(" ", "").split(",");

    for(String s : strings){
      StdOut.print(s+"\t");
    }
    StdOut.println();

    sort(strings);

    for(String s : strings){
      StdOut.print(s+"\t");
    }
    StdOut.println();

  }

}
