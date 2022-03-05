package Ch_2_2;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 2022/3/5.
 */
public class Ex_2_2_01 {

  public static Comparable<Character>[] aux;
  public static Comparable<Character>[] input;

  public static void main(String[] args) {
    input = new Comparable[]{'A', 'E', 'Q', 'S', 'U', 'Y', 'E', 'I', 'N', 'O', 'S', 'T'};
    aux = new Comparable[input.length];
    merge(input, 0, 5, 11);
    System.out.printf("Answer is: ");
    PrintUtil.show(input);

  }

  public static void merge(Comparable[] a, int lo, int mid, int hi) {
    int i = lo, j = mid + 1;
    for (int k = 0; k <= hi; k++) {
      aux[k] = a[k];
    }
    System.out.printf("%s ", "input: k");
    PrintUtil.show(input, 0, input.length, true);
    System.out.printf("%5s %5s\n", "i", "j");
    for (int k = lo; k <= hi; k++) {
      System.out.printf("%8s ", k);
      PrintUtil.show(input, 0, k, true);
      System.out.printf("%5s %5s | ", i, j);
      PrintUtil.show(aux, i, mid, true);
      PrintUtil.show(aux, j, aux.length, false);
      if (i > mid) {
        a[k] = aux[j++];
      }
      else if (j > hi) {
        a[k] = aux[i++];
      }
      else if (less(aux[i], aux[j])) {
        a[k] = aux[i++];
      }
      else {
        a[k] = aux[j++];
      }
    }
  }

  public static boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }
}
