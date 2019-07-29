package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/29.
 */

public class Ex_1_3_42 {

  public static class _Stack<Item> implements Iterable<Item> {

    public _Stack(_Stack<Item> another) {
      _Stack<Item> temp = new _Stack<>();
      while (!another.isEmpty()) {
        temp.push(another.pop());
      }
      while (!temp.isEmpty()) {
        Item item = temp.pop();
        this.push(item); // new node
        another.push(item); // new node
      }
    }

    public _Stack() {

    }

    private Node first;

    private int N;

    private class Node {

      Item item;
      Node next;
    }

    public void push(Item item) {
      Node oldfirst = first;
      first = new Node();
      first.item = item;
      first.next = oldfirst;
      N++;
    }

    public Item pop() {
      if (isEmpty()) {
        return null;
      }
      Item item = first.item;
      first = first.next;
      N--;
      return item;
    }

    public Item peek() {
      return first.item;
    }

    public int size() {
      return N;
    }

    public boolean isEmpty() {
      return N == 0;
    }

    @Override
    public Iterator<Item> iterator() {
      return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

      private Node current = first;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public Item next() {
        Item item = current.item;
        current = current.next;
        return item;
      }
    }
  }

  public static void main(String[] args) {
    _Stack<Integer> s = new _Stack<>();
    int N = 6;
    for (int i = 0; i < N; i++) {
      s.push(i);
    }
    _Stack<Integer> r = new _Stack<>(s);
    r.push(7);
    PrintUtil.show(s);
    PrintUtil.show(r);
    while (!r.isEmpty()) {
      StdOut.printf("%d ", r.pop());
    }
    StdOut.println();
    PrintUtil.show(s);
//    5 4 3 2 1 0
//    7 5 4 3 2 1 0
//    7 5 4 3 2 1 0
//    5 4 3 2 1 0

  }
}
