package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/24.
 */

public class Ex_1_3_32 {

  public static class Steque<Item> implements Iterable<Item> {

    Node first;
    Node last;
    int N;

    public void push(Item item) {
      Node x = new Node(item);
      if (isEmpty()) {
        first = x;
        last = x;
      } else {
        x.next = first;
        first = x;
      }
      N++;
    }


    public Item pop() {
      if (isEmpty()) {
        return null;
      }

      Node oldfirst = first;
      Item item = oldfirst.item;
      if (size() == 1) {
        first = null;
        last = null;
      } else {
        first = first.next;
        oldfirst.next = null;
      }
      N--;
      return item;
    }


    public void enqueue(Item item) {
      Node x = new Node(item);
      if (isEmpty()) {
        first = x;
        last = x;
      } else {
        last.next = x;
        last = x;
      }
      N++;
    }

    public int size() {
      return N;
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public class LinkedListIterator implements Iterator<Item> {

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

    @Override
    public Iterator<Item> iterator() {
      return new LinkedListIterator();
    }

    private class Node {

      Item item;
      Node next;

      public Node(Item item) {
        this.item = item;
      }

      @Override
      public String toString() {
        return item.toString();
      }
    }
  }

  public static void main(String[] args) {
    Steque<Integer> steque = new Steque<>();
    steque.push(0);
    steque.push(1);
    steque.push(2);
    steque.push(3);
    steque.push(4);
    StdOut.println("push 0 1 2 3 4");
    PrintUtil.show(steque);
    StdOut.println("enqueue 100 200 300 400");
    steque.enqueue(100);
    steque.enqueue(200);
    steque.enqueue(300);
    steque.enqueue(400);
    PrintUtil.show(steque);
    StdOut.println("test pop");
    while (!steque.isEmpty()) {
      StdOut.printf("%s ", steque.pop());
    }
    StdOut.println();
//    push 0 1 2 3 4
//    4 3 2 1 0
//    enqueue 100 200 300 400
//    4 3 2 1 0 100 200 300 400
//    test pop
//    4 3 2 1 0 100 200 300 400
  }
}
