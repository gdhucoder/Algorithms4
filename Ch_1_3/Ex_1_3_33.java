package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/24.
 */

public class Ex_1_3_33 {

  public static class _Deque<Item> implements Iterable<Item> {

    Node first;
    Node last;
    int N;

    public void pushLeft(Item item) {
      Node n = new Node(item);
      n.next = first;
      if (last == null) {
        last = n;
      } else {
        first.prev = n;
      }
      first = n;
      N++;
    }

    public void pushRight(Item item) {
      Node n = new Node(item);
      n.prev = last;
      if (first == null) {
        first = n;
      } else {
        last.next = n;
      }
      last = n;
      N++;
    }

    public Item popLeft() {
      Node oldfirst = first;
      Item item = oldfirst.item;
      Node n = first.next;
      oldfirst.item = null;
      oldfirst.next = oldfirst;
      first = n;
      if (n == null) {
        last = null;
      } else {
        n.prev = null;
      }
      N--;
      return item;
    }

    public Item popRight() {
      Node oldlast = last;
      Item item = oldlast.item;
      Node n = last.prev;
      oldlast.item = null;
      oldlast.prev = oldlast;
      last = n;
      if (n == null) {
        first = null;
      } else {
        n.next = null;
      }
      N--;
      return item;
    }

    public int size() {
      return N;
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public class LinkedListIterator implements Iterator<Item> {

      Node cur = first;

      @Override
      public boolean hasNext() {
        return cur != null;
      }

      @Override
      public Item next() {
        Item item = cur.item;
        cur = cur.next;
        return item;
      }
    }

    @Override
    public Iterator<Item> iterator() {
      return new LinkedListIterator();
    }

    private class Node {

      Item item;
      Node prev;
      Node next;

      public Node(Item item) {
        this.item = item;
      }

      @Override
      public String toString() {
        return item.toString();
      }
    }
  }

  public static void main(String[] args) {

    _Deque<Integer> dq = new _Deque<>();

    dq.pushLeft(0);
    dq.pushLeft(1);
    dq.pushLeft(2);
    dq.pushLeft(3);
    dq.pushLeft(4);
    PrintUtil.show(dq); // 4 3 2 1 0

    dq.pushRight(10);
    dq.pushRight(20);
    dq.pushRight(30);
    PrintUtil.show(dq); // 4 3 2 1 0 10 20 30

    _Deque<Integer> anotherQ = new _Deque<>();
    while (!dq.isEmpty()) {
      int num = dq.popLeft();
      anotherQ.pushLeft(num);
      StdOut.printf("%s ", num); // 4 3 2 1 0 10 20 30
    }
    StdOut.println();

    PrintUtil.show(anotherQ); // 30 20 10 0 1 2 3 4
    while (!anotherQ.isEmpty()) {
      int num = anotherQ.popRight();
      StdOut.printf("%s ", num); // 4 3 2 1 0 10 20 30
    }
    StdOut.println();
  }
}
