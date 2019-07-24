package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 * Created by HuGuodong on 2019/7/24.
 */

public class Ex_1_3_35 {

  public static class _RandomQueue<Item> {

    int N;
    Item[] a;

    public _RandomQueue() {
      a = (Item[]) new Object[1];
    }

    private void resize(int cap) {
      Item[] temp = (Item[]) new Object[cap];
      for (int i = 0; i < N; i++) {
        temp[i] = a[i];
      }
      a = temp;
    }

    public void enqueue(Item item) {
      if (N == a.length) {
        resize(2 * a.length);
      }
      a[N++] = item;
    }

    public Item dequeue() {
      if (isEmpty()) {
        return null;
      }
      if (N > 0 && N == a.length / 4) {
        resize(a.length / 2);
      }
      int r = StdRandom.uniform(N);
      Item item = a[r];
      // delete
      a[r] = a[N - 1];
      a[N - 1] = null;
      N--;
      return item;
    }

    public Item sample() {
      return a[StdRandom.uniform(N)];
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public int size() {
      return N;
    }
  }

  public static void main(String[] args) {
    _RandomQueue<Integer> q = new _RandomQueue<>();
    int N = 20;
    for (int i = 0; i < N; i++) {
      q.enqueue(i);
    }
    // sample
    for (int i = 0; i < N; i++) {
      StdOut.printf("%d ", q.sample());
    }
    StdOut.println();
    // dequeue
    while (!q.isEmpty()) {
      StdOut.printf("%d ", q.dequeue());
    }
    StdOut.println();
  }
}
