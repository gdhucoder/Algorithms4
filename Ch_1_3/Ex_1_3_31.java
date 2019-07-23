package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * Created by HuGuodong on 2019/7/22.
 */

public class Ex_1_3_31 {

  public static class _DoubleNode<Item> {

    private Node first;
    private Node last;
    private int N;

    public void insertAtBeginning(Item item) {
      Node x = new Node(item);
      if (isEmpty()) {
        first = x;
        last = x;
      } else {
        first.prev = x;
        x.next = first;
        first = x;
      }
      N++;
    }

    public Item removeFromBeginning() {
      if (isEmpty()) {
        return null;
      }
      Node n = first;
      Item item = n.item;
      if (size() == 1) {
        first = null;
        last = null;
      } else {
        first = first.next;
        first.prev = null;
        n.next = null;
      }
      N--;
      return item;
    }

    public Item removeAtEnd() {
      if (isEmpty()) {
        return null;
      }
      Node n = last;
      Item item = n.item;
      if (size() == 1) {
        first = null;
        last = null;
      } else {
        last = last.prev;
        last.next = null;
        n.prev = null;
      }
      N--;
      return item;
    }


    public void insertAtEnd(Item item) {
      Node x = new Node(item);
      if (isEmpty()) {
        first = x;
        last = x;
      } else {
        last.next = x;
        x.prev = last;
        last = x;
      }
      N++;
    }

    public void print() {
      Node x = first;
      while (x != null) {
        StdOut.printf("%s ", x.item);
        x = x.next;
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

      Item item;
      Node prev;
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

  @Test
  public void testRemoveAtEnd() {
    _DoubleNode<String> db = initDB();
    while (!db.isEmpty()) {
      while (!db.isEmpty()) {
        StdOut.printf("%s ", db.removeAtEnd());
      }
    }
    StdOut.println();
//    init DB
//    g f e d c b a
//    a b c d e f g
  }

  public static _DoubleNode<String> initDB() {
    _DoubleNode<String> db = new _DoubleNode<>();

    // Test insert at beginning
    db.insertAtBeginning("a");
    db.insertAtBeginning("b");
    db.insertAtBeginning("c");
    db.insertAtBeginning("d");
    db.insertAtBeginning("e");
    db.insertAtBeginning("f");
    db.insertAtBeginning("g");
    StdOut.println("init DB");
    db.print();
    return db;
  }

  public static void main(String[] args) {
    _DoubleNode<String> db = new _DoubleNode<>();

    // Test insert at beginning
    db.insertAtBeginning("a");
    db.insertAtBeginning("b");
    db.insertAtBeginning("c");
    db.insertAtBeginning("d");
    db.insertAtBeginning("e");
    db.insertAtBeginning("f");
    db.insertAtBeginning("g");
    db.print();

    //
    StdOut.println(db.size());
    StdOut.println(db.last);
    StdOut.println(db.first);
    // Test insert at end
    db.insertAtEnd("h");
    db.insertAtEnd("i");
    db.insertAtEnd("j");
    db.insertAtEnd("k");
    db.print();
    // g f e d c b a h i j k

    // Test remove from beginning
    while (!db.isEmpty()) {
      StdOut.printf("%s ", db.removeFromBeginning());
    }
    StdOut.println();
//    g f e d c b a h i j k

  }
}
