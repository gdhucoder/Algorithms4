package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 * Created by HuGuodong on 2019/7/24.
 */

public class Ex_1_3_34 {

  public static class _RandomBag<Item> implements Iterable<Item> {

    private int N;
    private Item[] a;

    public _RandomBag() {
      a = (Item[]) new Object[1];
    }

    public void add(Item item) {
      if (N == a.length) {
        resize(2 * a.length);
      }
      a[N++] = item;
    }

    private void resize(int cap) {
      Item[] temp = (Item[]) new Object[cap];
      for (int i = 0; i < N; i++) {
        temp[i] = a[i];
      }
      a = temp;
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public int size() {
      return N;
    }

    public class RandomArrayIterator implements Iterator<Item> {

      Item[] copy;
      int size = N; // number of elements in the bag
      int curIndex; // current index of copy array

      public RandomArrayIterator() {

        // copy an array
        copy = (Item[]) new Object[size];

        for (int i = 0; i < size; i++) {
          copy[i] = a[i];
        }

        // random order
        for (int i = 0; i < size; i++) {
          int r = i + StdRandom.uniform(size - i);
          Item temp = copy[i];
          copy[i] = copy[r];
          copy[r] = temp;
        }
      }

      @Override
      public boolean hasNext() {
        return curIndex < size;
      }

      @Override
      public Item next() {
        return copy[curIndex++];
      }
    }

    @Override
    public Iterator<Item> iterator() {
      return new RandomArrayIterator();
    }
  }

  public static void main(String[] args) {
    _RandomBag<Integer> r = new _RandomBag<>();
    int N = 20;
    for (int i = 0; i < N; i++) {
      r.add(i);
    }
    for (int i = 0; i < 10; i++) {
      for (Integer n : r) {
        StdOut.printf("%d ", n);
      }
      StdOut.println();
    }
//    12 11 8 19 4 9 7 1 5 17 18 0 6 15 14 16 3 10 13 2
//    8 0 18 17 19 14 7 15 11 4 12 1 13 6 3 5 10 2 9 16
//    16 14 15 8 18 0 13 5 17 10 9 6 3 4 12 1 2 11 7 19
//    12 4 3 7 18 5 8 19 1 9 17 15 14 2 0 10 16 6 13 11
//    0 11 9 14 10 3 18 19 6 12 15 4 13 1 7 2 17 16 8 5
//    14 4 9 11 8 1 13 18 16 19 12 2 0 6 5 15 17 7 3 10
//    10 19 18 15 9 3 12 13 0 7 8 2 5 4 11 14 1 16 17 6
//    6 4 15 16 8 5 1 12 19 10 14 3 0 7 9 17 11 18 13 2
//    18 10 8 14 6 2 13 9 12 17 0 1 5 7 19 16 15 4 11 3
//    8 10 13 17 18 7 19 14 9 11 5 3 15 4 6 12 0 2 1 16
  }


}
