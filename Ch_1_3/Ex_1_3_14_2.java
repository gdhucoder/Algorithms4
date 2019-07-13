package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/14.
 */

public class Ex_1_3_14_2 {

  /**
   * version 2: we use resize array
   */
  public static class _ResizingArrayQueueOfStrings<Item> implements Iterable<Item> {

    private int N;
    private int MAX_CAP;
    private int head;
    private int tail;
    private Item[] a;

    public _ResizingArrayQueueOfStrings(int cap) {
      a = (Item[]) new Object[cap];
      MAX_CAP = cap;
    }

    public void enqueue(Item s) {

      if (isFull()) {
        resize(N * 2);
      }

      if (tail == MAX_CAP) {
        tail = 0;
      }
      a[tail++] = s;
      N++;
    }

    public Item dequeue() {

      if (N == a.length / 4) {
        resize(a.length / 2);
      }

      if (head == MAX_CAP) {
        head = 0;
      }
      Item ret = a[head];
      a[head] = null;
      head++;
      N--;
      return ret;
    }

    private void resize(int capacity) {
      Item[] cpy = (Item[]) new Object[capacity];
      int i = 0;
      for (Item item : this) {
        cpy[i++] = item;
      }
      head = 0;
      tail = i;
      MAX_CAP = capacity;
      StdOut.printf("\narray is resized to capacity: %d\n", capacity);
      PrintUtil.show(cpy);
      a = cpy;
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

    public Iterator<Item> iterator() {
      return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<Item> {

      private int front = head;
      private int count = 0;

      @Override
      public boolean hasNext() {
        return ++count <= N;
      }

      @Override
      public Item next() {
        if (front == MAX_CAP) {
          front = 0;
        }
        Item ret = a[front++];
        return ret;
      }
    }

  }

  public static void main(String[] args) {
    _ResizingArrayQueueOfStrings<String> q = new _ResizingArrayQueueOfStrings<>(1);
    q.enqueue("1");
    q.enqueue("2");
    q.enqueue("3");
    q.enqueue("4");
    q.enqueue("5");
    q.enqueue("6");
    q.enqueue("7");

    // foreach
    for (String s : q) {
      StdOut.printf("%s ", s);
    }
    StdOut.println();
    // dequeue
    while (!q.isEmpty()) {
      StdOut.printf("dequeue -> %s \n", q.dequeue());
    }

    q.enqueue("1");
    q.enqueue("2");
    q.enqueue("3");
    q.enqueue("4");
    q.enqueue("5");
    q.enqueue("6");
    q.enqueue("7");

    StdOut.printf("dequeue -> %s \n", q.dequeue());
    StdOut.printf("dequeue -> %s \n", q.dequeue());
    StdOut.printf("dequeue -> %s \n", q.dequeue());
    StdOut.printf("dequeue -> %s \n", q.dequeue());
    StdOut.printf("dequeue -> %s \n", q.dequeue());
    StdOut.printf("dequeue -> %s \n", q.dequeue());

    q.enqueue("1");
    q.enqueue("2");
    q.enqueue("3");

    // dequeue
    while (!q.isEmpty()) {
      StdOut.printf("dequeue -> %s \n", q.dequeue());
    }
//    array is resized to capacity: 2
//    1 null
//
//    array is resized to capacity: 4
//    1 2 null null
//
//    array is resized to capacity: 8
//    1 2 3 4 null null null null
//    1 2 3 4 5 6 7
//    dequeue -> 1
//    dequeue -> 2
//    dequeue -> 3
//    dequeue -> 4
//    dequeue -> 5
//
//    array is resized to capacity: 4
//    6 7 null null
//    dequeue -> 6
//
//    array is resized to capacity: 2
//    7 null
//    dequeue -> 7
//
//    array is resized to capacity: 4
//    1 2 null null
//
//    array is resized to capacity: 8
//    1 2 3 4 null null null null
//    dequeue -> 1
//    dequeue -> 2
//    dequeue -> 3
//    dequeue -> 4
//    dequeue -> 5
//
//    array is resized to capacity: 4
//    6 7 null null
//    dequeue -> 6
//    dequeue -> 7
//    dequeue -> 1
//    dequeue -> 2
//
//    array is resized to capacity: 2
//    3 null
//    dequeue -> 3
//
//    Process finished with exit code 0

  }
}
