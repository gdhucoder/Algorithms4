package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/17.
 */

public class Ex_1_3_21 {

  public static class _LinkedList<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {

      Item item;
      Node next;
    }

    public void insertAtFront(Item item) {
      Node oldfirst = first;
      first = new Node();
      first.item = item;
      first.next = oldfirst;
      N++;
    }

    public int size() {
      return N;
    }

    @Override
    public Iterator<Item> iterator() {
      return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {

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

    public boolean isEmpty() {
      return N == 0;
    }

  }

  public static boolean find(_LinkedList<String> l, String key) {
    for (String s : l)
      if (s.equals(key))
        return true;
    return false;
  }


  public static void main(String[] args) {
    _LinkedList<String> l = new _LinkedList<>();
    l.insertAtFront("a");
    l.insertAtFront("b");
    l.insertAtFront("c");
    l.insertAtFront("d");
    PrintUtil.show(l);
    StdOut.println("find c: " + find(l, "c"));
    StdOut.println("find e: " + find(l, "e"));
//    d c b a
//    find c: true
//    find e: false
  }
}
