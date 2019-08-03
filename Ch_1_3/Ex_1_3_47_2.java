package Ch_1_3;

import java.util.Iterator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/8/3.
 */

public class Ex_1_3_47_2 {

  public static class _Steque<Item> extends _AbstractLinkedList<Item> implements Iterable<Item> {

    public void concat(_Steque<Item> s) {
      if (!s.isEmpty()) {
        Node first = last.next;
        last.next = s.last.next;
        last = s.last;
        last.next = first;
        N += s.N;
      }
    }

    public class CircularListIterator implements Iterator<Item> {

      private Node cur = last == null ? null : last.next;

      int k;

      @Override
      public boolean hasNext() {
        if (last == null) {
          return false;
        } else {
          return k < N;
        }
      }

      @Override
      public Item next() {
        Item item = cur.item;
        cur = cur.next;
        k++;
        return item;
      }
    }

    @Override
    public Iterator<Item> iterator() {
      return new CircularListIterator();
    }

    private Node last;

    public void push(Item item) {
      Node n = new Node(item);
      if (last == null) {
        last = n;
      } else {
        n.next = last.next;
      }
      last.next = n;
      N++;
    }

    public Item pop() {
      Node n = last.next;
      last.next = last.next.next;
      N--;
      if (N == 0) {
        last = null;
      }
      return n.item;
    }

    // add at bottom
    public void enqueue(Item item) {
      Node n = new Node(item);
      if (last == null) {
        last = n;
        last.next = n;
      } else {
        n.next = last.next;
        last.next = n;
      }
      last = n;
      N++;
    }
  }

  public static void main(String[] args) {
    _Steque<Integer> steque = new _Steque<>();
    for (int i = 0; i < 10; i++) {
      steque.push(i);
    }

    for (int i = 11; i < 20; i++) {
      steque.enqueue(i);
    }
//    9 8 7 6 5 4 3 2 1 0 11 12 13 14 15 16 17 18 19
    PrintUtil.show(steque);

    _Steque<Integer> s2 = new _Steque<>();
    s2.push(20);
    s2.enqueue(21);
    steque.concat(s2);
    PrintUtil.show(steque);
//    9 8 7 6 5 4 3 2 1 0 11 12 13 14 15 16 17 18 19 20 21
  }
}
