package Ch_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * Created by HuGuodong on 2019/7/7.
 */

public class _Queue<Item> implements Iterable<Item> {

  private Node first; // link to the least added node
  private Node last; // link to hte most added node
  private int N;

  private class Node {

    Item item;
    Node next;
  }

  public void enqueue(Item item) {
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
    } else {
      oldlast.next = last;
    }
    N++;
  }

  public Item dequeue() {
    Item item = first.item;
    first = first.next;
    if (isEmpty()) {
      last = null;
    }
    N--;
    return item;
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


  public static void main(String[] args) {
    _Queue<String> q = new _Queue<>();
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (item.equals("-")) {
        StdOut.print(q.dequeue() + " ");
      } else {
        q.enqueue(item);
      }
    }

    StdOut.println(q.size());

    for (String s : q) {
      StdOut.println(s);
    }

//    a b c d e - -
//    a b ^D
//    3
//    c
//    d
//    e

  }


}

