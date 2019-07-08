package Ch_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by HuGuodong on 2019/7/7.
 */

public class Ex_1_3_08 {

  public static class DoublingStackOfStrings {

    private String[] a;
    private int N;

    public DoublingStackOfStrings() {
      a = new String[1];
    }

    private void resize(int cap) {
      String[] temp = new String[cap];
      for (int i = 0; i < N; i++) {
        temp[i] = a[i];
      }
      a = temp;
    }

    public void push(String item) {
      if (N == a.length) { // array is full
        resize(2 * a.length);
      }
      a[N++] = item;
    }

    public String pop() {
      String item = a[--N];
      a[N] = null;
      if (N == a.length / 4) { // array is a quarter full
        resize(a.length / 2);
      }
      return item;
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public int sizeOfArray() {
      return a.length;
    }

    public int size() {
      return N;
    }
  }

  public static void main(String[] args) {
    DoublingStackOfStrings s = new DoublingStackOfStrings();
    // it was - the best - of times - - - it was - the - -
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (item.equals("-")) {
        if (!s.isEmpty()) {
          StdOut.println(s.pop());
        }
      } else {
        s.push(item);
      }
    }

    StdOut.printf("%d left on stack\n", s.size());
    StdOut.printf("%d array size", s.sizeOfArray());
//    input : it was - the best - of times - - - it was - the - -
//    was
//    best
//    times
//    of
//    the
//    was
//    the
//    it
//    ^D
//    1 left on stack
//    2 array size

  }
}
