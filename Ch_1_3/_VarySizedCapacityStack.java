package Ch_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * Created by HuGuodong on 2019/7/1.
 */

public class _VarySizedCapacityStack<Item> implements Iterable<Item> {

  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {

    private int i = N;

    @Override
    public boolean hasNext() {
      return i > 0;
    }

    @Override
    public Item next() {
      return a[--i];
    }
  }

  private Item[] a;
  private int N;

  public _VarySizedCapacityStack(int cap) {
    a = (Item[]) new Object[cap];
  }

  public _VarySizedCapacityStack() {
    a = (Item[]) new Object[1];
  }

  public void push(Item item) {
    if (N == a.length) {
      resize(2 * a.length);
    }
    a[N++] = item;
  }

  public Item pop() {
    Item itm = a[--N];
    a[N] = null;
    if (N > 0 && N == a.length / 4) {
      resize(a.length / 2);
    }
    return itm;
  }

  public int size() {
    return N;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  private void resize(int max) {
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < N; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public static void main(String[] args) {
    _VarySizedCapacityStack<String> s;
    s = new _VarySizedCapacityStack<>();
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (!item.equals("-")) {
        s.push(item);
      } else if (!s.isEmpty()) {
        StdOut.print(s.pop() + " ");
      }
    }
    StdOut.printf("( %d left on stack )\n", s.size());

//    to be or not - to - be is a question
//    not to
//    ^D
//    ( 7 left on stack )
    for (String ss :
        s) {
      StdOut.println(ss);
    }
  }
}
