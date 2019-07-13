package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * Created by HuGuodong on 2019/7/14.
 */

public class Ex_1_3_14 {

  /**
   * Version 1: we use a fixed size array
   */
  public static class _ResizingArrayQueueOfStrings<String> implements Iterable<String> {

    private int N;
    private final int MAX_CAP;
    private int head;
    private int tail;
    private String[] a;

    public _ResizingArrayQueueOfStrings(int cap) {
      a = (String[]) new Object[cap];
      MAX_CAP = cap;
    }

    public void enqueue(String s) {
      if (!isFull()) {
        if (tail == MAX_CAP) {
          tail = 0;
        }
        a[tail++] = s;
        N++;
      }
    }

    public String dequeue() {
      if (isEmpty()) {
        throw new IllegalStateException("queue is empty!");
      }
      if (head == MAX_CAP) {
        head = 0;
      }
      String ret = a[head];
      a[head] = null;
      head++;
      N--;
      return ret;
    }

    public boolean isEmpty() {
      return N == 0;
    }

    private boolean isFull() {
      return N == a.length;
    }

    public int size() {
      return N;
    }

    public Iterator<String> iterator() {
      return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<String> {

      private int front = head;
      private int count = 0;

      @Override
      public boolean hasNext() {
        return ++count <= N;
      }

      @Override
      public String next() {
        if (front == MAX_CAP) {
          front = 0;
        }
        String ret = a[front++];
        return ret;
      }
    }

  }

  public static void main(String[] args) {
    _ResizingArrayQueueOfStrings<String> q = new _ResizingArrayQueueOfStrings<>(5);
    q.enqueue("1");
    q.enqueue("2");
    q.enqueue("3");
    q.enqueue("4");
    q.enqueue("5");
    assert q.isFull() == true;
    assert q.size() == 5;
    assert q.dequeue().equals("1");
    assert q.dequeue().equals("2");

    q.enqueue("6");
    q.enqueue("7");

    // foreach
    for (String s : q) {
      StdOut.printf("%s ", s);
    }
    StdOut.println();
    // dequeue
    while (!q.isEmpty()) {
      StdOut.printf("%s ", q.dequeue());
    }


  }
}
