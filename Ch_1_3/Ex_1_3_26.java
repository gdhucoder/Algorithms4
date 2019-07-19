package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/20.
 */

public class Ex_1_3_26 {


  public static class _LinkedList {

    Node first;

    public void insertAtFirst(String item) {
      Node oldfirst = first;
      first = new Node(item);
      first.next = oldfirst;
    }

    public void print() {
      Node x = first;
      if (x == null) {
        StdOut.println("empty list");
        return;
      }
      while (x != null) {
        StdOut.printf("%s->", x.key);
        x = x.next;
      }
      StdOut.printf("null\n");
    }
  }

  public static class Node {

    String key;
    Node next;

    public Node(String key) {
      this(key, null);
    }

    public Node(String key, Node next) {
      this.key = key;
      this.next = next;
    }

    public Node append(String key) {
      Node n = new Node(key);
      this.next = n;
      return n;
    }

  }

  public static void remove(_LinkedList l, String key) {
    if (l == null) {
      return;
    }
    Node x = l.first;
    while (x != null && x.key.equals(key)) {
      x = x.next;
    }
    l.first = x;
    if (x == null) {
      return;
    }
    while (x.next != null) {
      if (x.next.key.equals(key)) {
        x.next = x.next.next;
      } else {
        x = x.next;
      }
    }
  }

  public static void main(String[] args) {
    _LinkedList l = new _LinkedList();
    l.insertAtFirst("b");
    l.insertAtFirst("a");
    l.insertAtFirst("b");
    l.insertAtFirst("b");
    l.insertAtFirst("a");
    l.insertAtFirst("a");
    l.insertAtFirst("a");
    l.insertAtFirst("a");
    l.insertAtFirst("a");
    l.insertAtFirst("a");
    l.insertAtFirst("a");
    l.insertAtFirst("a");
    l.insertAtFirst("a");
    l.insertAtFirst("c");
    l.print();
    remove(l, "b");
    l.print();
    remove(l, "a");
    l.print();
    remove(l, "c");
    l.print();

//    c->a->a->a->a->a->a->a->a->a->b->b->a->b->null
//    c->a->a->a->a->a->a->a->a->a->a->null
//    c->null
//    empty list

  }


}
