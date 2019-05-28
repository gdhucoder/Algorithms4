package Ch_2_4;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import tools.ArrayGenerator;

/**
 * Created by HuGuodong on 2019/5/19.
 */

public class _MaxPriorityQueue<Key extends Comparable<Key>> {

  private Key[] pq;
  private int N;

  /**
   * create a priority queue
   */
  public _MaxPriorityQueue() {

  }

  /**
   * create a priority queue of initial capacity max
   */
  public _MaxPriorityQueue(int max) {
    pq = (Key[]) new Comparable[max + 1];
    N = 0;
  }

  public void insert(Key v) {
    pq[++N] = v;
    swim(N);
  }


  public Key max() {
    if (isEmpty()) {
      throw new IllegalStateException("qp is empty!");
    }
    return pq[1];
  }

  public Key delMax() {
    if (isEmpty()) {
      throw new IllegalStateException("qp is empty!");
    }
    Key max = pq[1];
    swap(1, N);
    pq[N] = null;
    N--;
    sink(1);
    return max;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      swap(k / 2, k);
      k /= 2;
    }
  }

  private void sink(int k) {
    while (k * 2 < N) {
      int j = 2 * k;
      if (j < N && less(j, j + 1)) {
        j++;
      }
      if (!less(k, j)) {
        break;
      }
      swap(k, j);
      k = j;
    }
  }

  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void swap(int i, int j) {
    Key temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
  }

  public static void main(String[] args) {
    String[] s = "T S R P N O A E I H G".split(" ");
//    StdRandom.shuffle(s);
    System.out.println(Arrays.toString(s));
    _MaxPriorityQueue<String> pq = new _MaxPriorityQueue<>(s.length);
    for (int i = 0; i < s.length; i++) {
      pq.insert(s[i]);
    }
    System.out.println(Arrays.toString(pq.pq));
    while (!pq.isEmpty()) {
      System.out.println(pq.delMax());
    }

    pq.delMax();
  }
}
