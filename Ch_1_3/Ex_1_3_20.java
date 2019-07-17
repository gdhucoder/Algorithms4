package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/17.
 */

public class Ex_1_3_20 {

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

    public Item deleteKth(int k) {
      if (isEmpty()) {
        throw new RuntimeException("list is empty");
      }
      if (k > N) {
        throw new IllegalArgumentException("k is larger than list size");
      }
      if (k <= 0) {
        throw new IllegalArgumentException("k should greater than zero");
      }

      if (k == 1) {
        Item ret = first.item;
        first = first.next;
        N--;
        return ret;
      } else {
        Node x = first;
        int count = 1; // starts from 1
        for (; x.next.next != null; x = x.next) {
          count++;
          if (count == k) {
            break;
          }
        }
        Item ret = x.next.item;
        x.next = x.next.next;
        N--;
        return ret;
      }
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
    StdOut.println(l.size());
    assert l.deleteKth(1) == 6;
    assert l.deleteKth(1) == 5;
    assert l.deleteKth(2) == 3;
    assert l.deleteKth(3) == 1;
  }
}
