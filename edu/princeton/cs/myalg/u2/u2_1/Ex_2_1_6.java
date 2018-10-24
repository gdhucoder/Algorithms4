package edu.princeton.cs.myalg.u2.u2_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2018/7/31.
 */

// TODO 建立一个key相等的数组。
public class Ex_2_1_6 {


  public static long time(String alg, ItemIdenticalKey[] a) {
    long time = System.currentTimeMillis();
    if (alg.equals("Insertion")) {
      Insertion.sort(a);
    }
    if (alg.equals("Selection")) {
      SelectionSort.sort(a);
    }
    if (alg.equals("ShellSort")) {
      ShellSort.sort(a);
    }
    // seconds
    long now = System.currentTimeMillis();
    return now - time;
  }

  public static long timeRandomInput(String alg, int N, int T) {
    // Use alg to sort T random arrays of length N
    long total = 0;
    ItemIdenticalKey[] a = new ItemIdenticalKey[N];
    for (int t = 0; t < T; t++) {
      for (int i = 0; i < N; i++) {
        a[i] = new ItemIdenticalKey(StdRandom.uniform());
      }
      total += time(alg, a);
    }
    return total;
  }


  public static void main(String[] args) {
    String alg1 = args[0];
    String alg2 = args[1];
    int N = Integer.parseInt(args[2]);
    int T = Integer.parseInt(args[3]);
    long t1 = timeRandomInput(alg1, N, T);
    long t2 = timeRandomInput(alg2, N, T);
    StdOut.printf("For %d random ItemIdenticalKey\n \t %s is", N, alg1);
    StdOut.printf(" %.2f times faster than %s\n", (0.0 + t2) / (0.0+ t1), alg2);

  }

}

class ItemIdenticalKey implements Comparable<ItemIdenticalKey>{

  double value;

  public ItemIdenticalKey(double value){
    this.value = value;
  }

  /**
   * compareTo永远返回零，意思是所有的key都相等
   * @param o
   * @return
   */
  @Override
  public int compareTo(ItemIdenticalKey o) {
    return 0;
  }
}