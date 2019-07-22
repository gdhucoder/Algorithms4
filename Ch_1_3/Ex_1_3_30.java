package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/20.
 */

public class Ex_1_3_30 {

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

    @Override
    public String toString() {
      return item.toString();
    }
  }

  public static Node reverse(Node x) {
    Node first = x;
    Node reverse = null;
    while (first != null) {
      Node second = first.next;
      first.next = reverse;
      reverse = first;
      first = second;
    }
    return reverse;
  }

  public static Node reverseV2(Node first) {
    if (first.next == null)
      return first;
    Node second = first.next;
    Node rever = reverseV2(second);
    second.next = first;
    first.next = null;
    return rever;
  }

  public static void print(Node cur) {
    while (cur != null) {
      StdOut.printf("%s ", cur.item);
      cur = cur.next;
    }
    StdOut.println();
  }


  public static void main(String[] args) {
    Node<Integer> first = new Node<>(1);
    first.append(2)
        .append(3)
        .append(4)
//         .append(5)
//         .append(6)
//         .append(7);
    ;
    print(first);
    Node rev = reverseV2(first);
    StdOut.println("recursive reverse");
    print(rev);
    StdOut.println("non-recursive reverse");
    print(reverse(rev));
  }
}
