package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/20.
 */

public class Ex_1_3_29 {

  public static class _Queue<Item> {

    Node tail;

    private class Node {

      public Node(Item item) {
        this.item = item;
      }

      Item item;
      Node next;
    }

    /**
     * insert at last
     */
    public void enqueue(Item item) {
      if (tail == null) {
        tail = new Node(item);
        tail.next = tail;
      } else {
        Node front = tail.next;
        Node n = new Node(item);
        tail.next = n;
        tail = n;
        tail.next = front;
      }
    }

    public void print() {
      Node cur = tail.next;
      while (cur != tail) {
        StdOut.printf("%s->", cur.item);
        cur = cur.next;
      }
      StdOut.println(cur.item);
    }

    public boolean isEmpty() {
      return tail == null;
    }


    /**
     * remove first element in queue
     */
    public Item dequeue() {
      if (tail == tail.next) {
        Item item = tail.item;
        tail = null;
        return item;
      }
      Node front = tail.next;
      Item item = front.item;
      tail.next = front.next;
      return item;
    }
  }

  public static void main(String[] args) {
    _Queue<Integer> q = new _Queue<>();
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(5);
    q.enqueue(6);
    q.print();
    StdOut.println("dequeue");
    while (!q.isEmpty()) {
      StdOut.printf("%s ", q.dequeue());
    }
    StdOut.println();
//    1->2->3->4->5->6
//    dequeue
//    1 2 3 4 5 6
  }

}
