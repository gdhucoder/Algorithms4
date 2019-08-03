package Ch_1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import org.junit.Test;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/8/2.
 */

public class Ex_1_3_47 {

  @Test
  public void testQ() {
    _Queue<Integer> q1 = new _Queue<>();
    _Queue<Integer> q2 = new _Queue<>();
    for (int i = 0; i < 5; i++) {
      q1.enqueue(i);
    }
    for (int i = 10; i < 20; i++) {
      q2.enqueue(i);
    }
    q1.concat(q2);
    PrintUtil.show(q1);
//    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
    while (!q1.isEmpty()) {
      StdOut.printf("%d->", q1.dequeue());
    }
    StdOut.println();
//    0->1->2->3->4->10->11->12->13->14->15->16->17->18->19->
  }


  public static class _Queue<Item> implements Iterable<Item> {

    Node last;
    int N;

    public void enqueue(Item item) {
      Node n = new Node(item);
      if (isEmpty()) {
        last = n;
        last.next = n;
      } else {
        Node old = last;
        last = n;
        last.next = old.next; // link first node
        old.next = last; // link last node
      }
      N++;
    }

    public Item dequeue() {
      Item item = last.next.item;
      if (last.next == last) {// there is only one node in the link list
        last = null;
      } else {
        last.next = last.next.next;
      }
      // only one element in the list
      N--;
      return item;
    }

    public void concat(_Queue<Item> q) {
      if (!q.isEmpty()) {
        Node first = last.next;
        last.next = q.last.next;
        last = q.last;
        last.next = first;
        N += q.N;
      }
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public int size() {
      return N;
    }

    private class Node {

      public Node(Item item) {
        this.item = item;
      }

      Item item;
      Node next;
    }

    public class CircularListIterator implements Iterator<Item> {

      private Node cur = N == 0 ? null : last.next; // first node
      private int k;

      @Override
      public boolean hasNext() {
        if (cur == null) {
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
  }

  public static class _Stack<Item> {

    private Node last;
    private int N;


    /**
     * e.g.
     */
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
      return n.item;
    }

    public void catenation(_Stack<Item> s) {
      if (!s.isEmpty() && !this.isEmpty()) {
        Node first = last.next;
        this.last.next = s.last.next;
        this.last = s.last;
        this.last.next = first;
        N += s.N;
      } else if (this.isEmpty() && !s.isEmpty()) {
        this.last = s.last;
        this.last.next = s.last.next;
        this.N = s.N;
      }
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public int size() {
      return N;
    }

    public void print() {
      if (!isEmpty()) {
        Node x = last.next;
        while (x != last) {
          StdOut.printf("%s->", x.item.toString());
          x = x.next;
        }
        StdOut.printf("%s->\n", x.item.toString());
      }

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
    _Stack<Integer> s = new _Stack<>();
    for (int i = 0; i < 10; i++) {
      s.push(i);
    }

    _Stack<Integer> ss = new _Stack<>();
    for (int i = 10; i < 20; i++) {
      ss.push(i);
    }
    s.catenation(ss);
    s.print();
  }
}
