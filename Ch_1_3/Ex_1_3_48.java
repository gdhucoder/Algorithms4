package Ch_1_3;

import Ch_1_3.Ex_1_3_33._Deque;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/8/5.
 */

public class Ex_1_3_48 {

  public static class LeftStack<Item> {

    private _Deque<Item> de;
    public int N;

    public LeftStack(_Deque<Item> de) {
      this.de = de;
    }

    public void push(Item item) {
      de.pushLeft(item);
      N++;
    }

    public Item pop() {
      if (isEmpty()) {
        return null;
      }
      N--;
      return de.popLeft();
    }


    public boolean isEmpty() {
      return N == 0;
    }

    public int size() {
      return N;
    }
  }

  public static class RightStack<Item> {

    private _Deque<Item> de;
    public int N;

    public RightStack(_Deque<Item> de) {
      this.de = de;
    }

    public void push(Item item) {
      de.pushRight(item);
      N++;
    }

    public Item pop() {
      if (isEmpty()) {
        return null;
      }
      N--;
      return de.popRight();
    }


    public boolean isEmpty() {
      return N == 0;
    }

    public int size() {
      return N;
    }
  }

  public static void main(String[] args) {
    _Deque<Integer> de = new _Deque<>();
    LeftStack<Integer> leftStack = new LeftStack<>(de);
    for (int i = 0; i < 5; i++) {
      leftStack.push(i);
    }
    while (!leftStack.isEmpty()) {
      StdOut.println(leftStack.pop());
    }
    RightStack<Integer> rightStack = new RightStack<>(de);
    for (int i = 5; i < 10; i++) {
      rightStack.push(i);
    }
    while (!rightStack.isEmpty()) {
      StdOut.println(rightStack.pop());
    }
  }
}
