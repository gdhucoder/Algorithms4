package Ch_1_3;


import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/19.
 */

public class Ex_1_3_24 {

  public static class Node<Item> {

    Item item;
    Node<Item> next;

    public Node(Item item) {
      this(item, null);
    }

    public Node(Item item, Node next) {
      this.item = item;
      this.next = next;
    }

    public Node append(Item item) {
      Node n = new Node(item);
      this.next = n;
      return n;
    }

  }

  public static void print(Node n) {
    if (n == null) {
      StdOut.println();
      return;
    }
    StdOut.printf("%s \t", n.item);
    print(n.next);
  }

//  public static <Item> void removesAfter(Node<Item> n) {
//    if (n == null || n.next == null) {
//      return;
//    }
//    n.next = n.next.next;
//  }

  public static void removesAfter(Node n) {
    if (n == null || n.next == null) {
      return;
    }
    n.next = n.next.next;
  }


  public static void main(String[] args) {

//    Node<String> n = new Node<>("a",
//                     new Node<>("b",
//                     new Node<>("c",
//                     new Node<>("d",
//                     new Node<>("e",
//                     new Node<>("f",
//                     new Node<>("g",
//                        null)
//                     ))))));
    Node<String> first = new Node<>("a");
    first.append("b").append("c").append("d").append("e");
    print(first);
    removesAfter(first);
    print(first);

  }


}
