package Ch_1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/20.
 */

public class Ex_1_3_28 {

  public static class Node<T> {

    T item;
    Node<T> next;

    public Node(T item) {
      this.item = item;
    }

    public Node append(T item) {
      Node x = new Node(item);
      this.next = x;
      return x;
    }
  }

  public static void print(Node cur) {
    while (cur != null) {
      StdOut.printf("%s ", cur.item);
      cur = cur.next;
    }
    StdOut.println();
  }

  /**
   * recursive implementation of max(node)
   */
  public static int recurMax(Node<Integer> n) {
    if (n.next == null) {
      return n.item;
    }
    return Math.max(n.item, recurMax(n.next));
  }


  public static void main(String[] args) {
    Node<Integer> first = new Node<>(1);
    first.append(2)
        .append(3)
        .append(3)
        .append(3)
        .append(3)
        .append(4)
        .append(10)
        .append(12)
        .append(30)
        .append(1);
    print(first);
//    1 2 3 3 3 3 4 10 12 30 1
//    30

    int max = recurMax(first);
    StdOut.println(max);
  }
}
