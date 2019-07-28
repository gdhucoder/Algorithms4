package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/28.
 */

public class Ex_1_3_40 {

  public static class MoveToFront<Item> {

    Node first;
    int N;

    public void insert(Item item) {
      if (isEmpty()) {
        first = new Node(item);
        N++;
      }
      Node prev = find(item);
      if (prev == null) {
        if (first.item.equals(item)) {
          return;
        } else {
          Node oldfirst = first;
          first = new Node(item);
          first.next = oldfirst;
          N++;
        }
      } else {
        Node newfirst = prev.next;
        prev.next = prev.next.next;
        newfirst.next = first;
        first = newfirst;
      }
    }

    /**
     * find previous node of item
     */
    public Node find(Item item) {
      if (isEmpty()) {
        return null;
      }
      Node cur = first;
      while (cur.next != null) {
        if (cur.next.item.equals(item)) {
          return cur;
        }
        cur = cur.next;
      }
      return null;
    }

    public void print() {
      for (Node x = first; x != null; x = x.next) {
        StdOut.printf("%s ", x.item);
      }
      StdOut.println();
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public int size() {
      return N;
    }

    private class Node {

      Node(Item item) {
        this.item = item;
      }

      Item item;
      Node next;

      @Override
      public String toString() {
        return item.toString();
      }
    }
  }

  public static void main(String[] args) {
    MoveToFront<String> m = new MoveToFront<>();
    m.insert("a");
    m.insert("a");
    m.insert("a");
    m.print();
    m.insert("b");
    m.insert("c");
    m.print(); // c b a
    m.insert("b");
    m.print(); // b c a
    m.insert("d");
    m.print(); // d b c a
    m.insert("a");
    m.print(); // a d b c
    m.insert("c");
    m.print(); // c a d b
    m.insert("e");
    m.print(); // e c a d b
//    a
//    c b a
//    b c a
//    d b c a
//    a d b c
//    c a d b
  }
}
