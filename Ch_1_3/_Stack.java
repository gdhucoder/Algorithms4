package Ch_1_3;

/**
 * Created by HuGuodong on 2019/7/4.
 */


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * Stack implement based on Linked List
 */
public class _Stack<Item> implements Iterable<Item> {

  private Node first;

  private int N;

  private class Node {

    Item item;
    Node next;
  }

  public void push(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;
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
    _Stack<String> s = new _Stack<>();
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (item.equals("-")) {
        StdOut.print(s.pop() + " ");
      } else {
        s.push(item);
      }
    }

    StdOut.println(s.size());

    for (String item :
        s) {
      StdOut.println(item);
    }
  }
}
