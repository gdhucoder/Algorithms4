package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/17.
 */

public class Ex_1_3_19 {

  public static class _LinkedList<Item> {

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

    public Item deleteAtLast() {
      if (isEmpty()) {
        return null;
      } else if (size() == 1) {
        Item ret = first.item;
        first = null;
        N--;
        return ret;
      } else {
        Node x = first;
        for (; x.next.next != null; x = x.next) {
        }
        Item ret = x.next.item;
        x.next = null;
        N--;
        return ret;
      }
    }

    public int size() {
      return N;
    }

    public boolean isEmpty() {
      return N == 0;
    }

  }

  public static void main(String[] args) {
    _LinkedList<Integer> l = new _LinkedList<>();
    l.insertAtFront(1);
    l.insertAtFront(2);
    l.insertAtFront(3);
    l.insertAtFront(4);
    l.insertAtFront(5);
    l.insertAtFront(6);
    while (!l.isEmpty()) {
      StdOut.println("removed: " + l.deleteAtLast() + ", after remove size: " + l.size());
    }
//    removed: 1, after remove size: 5
//    removed: 2, after remove size: 4
//    removed: 3, after remove size: 3
//    removed: 4, after remove size: 2
//    removed: 5, after remove size: 1
//    removed: 6, after remove size: 0
  }
}
