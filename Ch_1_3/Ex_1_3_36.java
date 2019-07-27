package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 * Created by HuGuodong on 2019/7/27.
 */

public class Ex_1_3_36 {

  public static class _RandomQueue<Item> implements Iterable<Item> {

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

    public class RandomIterator implements Iterator<Item> {

      Item[] copy;
      int num = N;
      int idx;

      public RandomIterator() {
        copy = (Item[]) new Object[num];
        for (int i = 0; i < num; i++) {
          copy[i] = a[i];
        }
        for (int i = 0; i < num; i++) {
          int r = i + StdRandom.uniform(num - i); // between i~n-1
          Item temp = copy[i];
          copy[i] = copy[r];
          copy[r] = temp;
        }
      }

      @Override
      public boolean hasNext() {
        return idx < num;
      }

      @Override
      public Item next() {
        return copy[idx++];
      }
    }

    @Override
    public Iterator<Item> iterator() {
      return new RandomIterator();
    }

  }

  public static void main(String[] args) {
    _RandomQueue<Integer> q = new _RandomQueue<>();
    int N = 20;
    for (int i = 0; i < N; i++) {
      q.enqueue(i);
    }
    for (Integer i : q) {
      StdOut.printf("%d ", i);
    }
    StdOut.println();
//    7 10 0 5 12 4 15 6 18 3 19 17 11 14 16 1 13 2 9 8
  }
}
