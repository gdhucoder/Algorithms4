package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * Created by HuGuodong on 2019/6/29.
 */

public class _FixedCapacityStackOfStrings {

  private String[] a;
  private int max;
  private int n;

  public _FixedCapacityStackOfStrings(int cap) {
    if (cap <= 0) {
      throw new IllegalArgumentException("cap must be > 0");
    }
    a = new String[cap];
    max = cap;
  }

  public void push(String item) {
    if (!isFul()) {
      a[n++] = item;
    }
  }

  public String pop() {
    if (!isEmpty()) {
      return a[--n];
    }
    return null;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public boolean isFul() {
    return n == max;
  }

  public int size() {
    return n;
  }

  @Test
  public void test() {
    _FixedCapacityStackOfStrings s = new _FixedCapacityStackOfStrings(3);
    s.push("a");
    s.push("b");
    s.push("c");
    s.push("d");
    StdOut.println(s.isFul());
    StdOut.println(s.size());
    while (!s.isEmpty()) {
      StdOut.println(s.pop());
    }
  }

  public static void main(String[] args) {

  }

}
