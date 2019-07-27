package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/27.
 */

public class Ex_1_3_38_2 {

  public static class LinkedListBasedGeneralQueue<Item> {

    Node first;
    Node last;
    int N;

    public void insert(Item item) {
      Node oldlast = last;
      last = new Node(item);
      if (oldlast == null) {
        first = last;
      } else {
        oldlast.next = last;
      }
      N++;
    }

    public Item delete(int k) {
      if (isEmpty()) {
        return null;
      }
      if (k < 1 || k > N) {
        throw new IllegalArgumentException("wrong k!");
      }
      // if remove first
      if (k == 1) {
        return removeFront();
      }
      // if k is not first
      Node prev = first;
      int cnt = 1;
      while (++cnt < k) {
        prev = prev.next;
      }
      Item item = prev.next.item;
      prev.next = prev.next.next;
      N--;
      if (isEmpty()) {
        last = null;
      }
      return item;
    }

    private Item removeFront() {
      if (isEmpty()) {
        return null;
      }
      Item item = first.item;
      first = first.next;
      N--;
      if (isEmpty()) {
        last = null;
      }
      return item;
    }

    public int size() {
      return N;
    }

    public boolean isEmpty() {
      return N == 0;
    }

    private class Node {

      public Node(Item item) {
        this.item = item;
      }

      Item item;
      Node next;
    }
  }

  public static void main(String[] args) {
    LinkedListBasedGeneralQueue<Integer> q = new LinkedListBasedGeneralQueue<>();
    q.insert(1);
    q.insert(2);
    q.insert(3);
    StdOut.println(q.delete(1));
    StdOut.println(q.delete(2));
    StdOut.println(q.delete(1));
    StdOut.println(q.isEmpty());
//    1
//    3
//    2
//    true
  }
}
