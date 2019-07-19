package Ch_1_3;


import static Ch_1_3.Ex_1_3_24.print;

import Ch_1_3.Ex_1_3_24.Node;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/20.
 */

public class Ex_1_3_25 {

  public static void insertAfter(Node cur, Node x) {
    if (cur == null || x == null) {
      return;
    }
    x.next = cur.next;
    cur.next = x;
  }

  public static void main(String[] args) {
    Node<String> a = new Node("a");
    a.append("c").append("d");
    StdOut.println("before insert:");
    print(a);
    Node<String> b = new Node<>("b");
    insertAfter(a, b);
    StdOut.println("after insert:");
    print(a);

//    before insert:
//    a 	c 	d
//    after insert:
//    a 	b 	c 	d

  }
}
