package Ch_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/1.
 */

public class _FixedCapacityStack<Item> {

  private Item[] a;
  private int N;

  public _FixedCapacityStack(int cap) {
    a = (Item[]) new Object[cap];
  }

  public void push(Item item) {
    a[N++] = item;
  }

  public Item pop() {
    return a[--N];
  }

  public int size() {
    return N;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public static void main(String[] args) {
    _FixedCapacityStack<String> s;
    s = new _FixedCapacityStack<>(100);
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
  }
}
