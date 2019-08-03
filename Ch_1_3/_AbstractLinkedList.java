package Ch_1_3;

/**
 * Created by HuGuodong on 2019/8/3.
 */

public class _AbstractLinkedList<Item> {

  public class Node {

    public Node(Item item) {
      this.item = item;
    }

    Item item;
    Node next;
  }

  public int N;

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

}
