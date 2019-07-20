package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/20.
 */

public class Ex_1_3_27 {

  public static class Node<T> {

    T item;
    Node next;

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

  public static int max(Node<Integer> n) {
    Integer max = 0;
    Node<Integer> cur = n;
    while (cur != null) {
      if (cur.item.compareTo(max) > 0) {
        max = cur.item;
      }
      cur = cur.next;
    }
    return max;
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
    StdOut.println(max(first));
//    1 2 3 3 3 3 4 10 12 30 1
//    30
  }
}
