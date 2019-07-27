package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/27.
 */

public class Ex_1_3_38 {


  public static class ArrayBasedGeneralizeQueue<Item> implements Iterable<Item> {

    Item[] a;
    int first;
    int last;
    int N;

    public ArrayBasedGeneralizeQueue() {
      a = (Item[]) new Object[2];
    }

    public void resize(int cap) {
      Item[] copy = (Item[]) new Object[cap];
      for (int i = 0; i < N; i++) {
        copy[i] = a[(first + i) % a.length];
      }
      first = 0;
      last = N;
      a = copy;
    }

    public int size() {
      return N;
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public void insert(Item x) {
      if (N == a.length) {
        resize(2 * a.length);
      }
      a[last++] = x;
      if (last == a.length) {
        last = 0;
      }
      N++;
    }

    public Item delete(int k) {
      Item cur = a[(first + k - 1) % a.length];
      // move
      for (int i = k; i < N; i++) {
        a[(first + i - 1) % a.length] = a[(first + i) % a.length];
      }
      N--;
      last = last - 1;
      if (last == -1) {
        last = a.length - 1;
      }
      a[last] = null;
      if (N > 0 && N == a.length / 4) {
        resize(a.length / 2);
      }
      return cur;
    }

    public class ArrayIterator implements Iterator<Item> {

      int start = first;
      int cnt = 0;
      int size = N;

      @Override
      public boolean hasNext() {
        return cnt < N;
      }

      @Override
      public Item next() {
        Item item = a[(start++) % a.length];
        cnt++;
        return item;
      }
    }

    @Override
    public Iterator<Item> iterator() {
      return new ArrayIterator();
    }
  }

  public static void main(String[] args) {
    ArrayBasedGeneralizeQueue<Integer> q = new ArrayBasedGeneralizeQueue<>();
    for (int i = 0; i < 10; i++) {
      q.insert(i);
    }
    PrintUtil.show(q);
    StdOut.println(q.delete(1));
    StdOut.println(q.delete(1));
    StdOut.println(q.delete(1));
    q.insert(10);
    q.delete(6);
    PrintUtil.show(q);
  }
}
