package Ch_1_3;

import static Ch_1_3.Ex_1_3_31._DoubleNode.*;

import com.sun.org.apache.xpath.internal.SourceTree;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * Created by HuGuodong on 2019/7/22.
 */

public class Ex_1_3_31 {

  public static class _DoubleNode<Item> {

    private Item item;
    private _DoubleNode prev;
    private _DoubleNode next;

    public _DoubleNode(Item item) {
      this.item = item;
    }

    public _DoubleNode(Item item, _DoubleNode prev, _DoubleNode next) {
      this.item = item;
      this.prev = prev;
      this.next = next;
    }

    public _DoubleNode append(Item item) {
      _DoubleNode n = new _DoubleNode(item);
      this.next = n;
      n.prev = this;
      return n;
    }


    public static <Item> void insertAtBeginning(_DoubleNode<Item> n, Item item) {
      while (n.prev != null) {
        n = n.prev;
      }
      _DoubleNode x = new _DoubleNode(item);
      x.next = n;
      n.prev = x;
    }

    public static <Item> void insertAtEnd(_DoubleNode<Item> n, Item item) {
      while (n.next != null) {
        n = n.next;
      }
      _DoubleNode x = new _DoubleNode(item);
      n.next = x;
      x.prev = n;
    }

    public static <Item> Item removeFromBeginning(_DoubleNode<Item> n) {
      while (n.prev != null) {
        n = n.prev;
      }
      Item item = n.item;
      n.next.prev = null;
      n.next = null;
      return item;
    }

    public static <Item> Item removeFromEnd(_DoubleNode<Item> n) {
      while (n.next != null) {
        n = n.next;
      }
      Item item = n.item;
      n.prev.next = null;
      n.prev = null;
      return item;
    }

    public static <Item> void insertAfter(_DoubleNode<Item> n, Item item) {
      _DoubleNode<Item> x = new _DoubleNode<Item>(item);
      if (n.next != null) {
        n.next.prev = x;
        x.next = n.next;
      }
      x.prev = n;
      n.next = x;
    }

    public static <Item> void insertBefore(_DoubleNode<Item> n, Item item) {
      _DoubleNode<Item> x = new _DoubleNode<Item>(item);
      if (n.prev != null) {
        n.prev.next = x;
        x.prev = n.prev;
      }
      x.next = n;
      n.prev = x;
    }


    /**
     * return a reference of node.
     */
    public static <Item> _DoubleNode remove(_DoubleNode<Item> n, Item key) {
      while (n.prev != null) {
        n = n.prev;
      }
      _DoubleNode ret = null;

      while (n != null) {
        if (n.item.equals(key)) {
//          StdOut.println("found");
//          StdOut.println(n.item);
          // found
          if (n.next != null) {
            ret = n.next;
            if (n.prev != null) {
              n.next.prev = n.prev;
            } else {
              n.next.prev = null;
            }
            n.next = null;
          }
          if (n.prev != null) {
            ret = n.prev;
            if (n.next != null) {
              n.prev.next = n.next;
            } else {
              n.prev.next = null;
            }
            n.prev = null;
          }
          break;
        }
        n = n.next;
      }
      return ret;
    }

    public static <Item> _DoubleNode remove(_DoubleNode<Item> n, _DoubleNode<Item> key) {
      return remove(n, key.item);
    }


    public static void print(_DoubleNode x) {
      while (x.prev != null) {
        x = x.prev;
      }
      while (x != null) {
        StdOut.printf("%s ", x.item);
        x = x.next;
      }
      StdOut.println();
    }

  }

  @Test
  public void testInsertAtBeginning() {
    _DoubleNode<Integer> d = new _DoubleNode<Integer>(1);
    d.append(2).append(3).append(4);
    StdOut.println("before insert: ");
    print(d);
    insertAtBeginning(d, 0);
    StdOut.println("after insert: ");
    print(d);
    insertAtBeginning(d, -1);
    StdOut.println("after insert: ");
    print(d);
    insertAtBeginning(d, -2);
    StdOut.println("after insert: ");
    print(d);
//    before insert:
//    1 2 3 4
//    after insert:
//    0 1 2 3 4
//    after insert:
//    -1 0 1 2 3 4
//    after insert:
//    -2 -1 0 1 2 3 4
  }

  @Test
  public void testRemoveFromBeginning() {
    _DoubleNode<Integer> d = new _DoubleNode<Integer>(1);
    insertAtBeginning(d, 2);
    insertAtBeginning(d, 3);
    insertAtBeginning(d, 4);
    StdOut.println("before remove");
    print(d);
    removeFromBeginning(d);
    removeFromBeginning(d);
    removeFromBeginning(d);
    StdOut.println("after remove");
    print(d);
//    before remove
//    4 3 2 1
//    after remove
//    1
  }

  @Test
  public void testInsertAndRemoveAtEnd() {
    _DoubleNode<Integer> d = new _DoubleNode<Integer>(1);
    StdOut.println("before insert");
    print(d);
    insertAtEnd(d, 2);
    insertAtEnd(d, 3);
    insertAtEnd(d, 4);
    insertAtEnd(d, 5);
    StdOut.println("after insert");
    print(d);
//    before insert
//    1
//    after insert
//    1 2 3 4 5

    removeFromEnd(d);
    removeFromEnd(d);
    removeFromEnd(d);
    removeFromEnd(d);
    StdOut.println("after remove at end");
    print(d);
//    after remove at end
//    1
  }

  @Test
  public void testInsertAfter() {
    _DoubleNode<Integer> d = new _DoubleNode<Integer>(1);
    print(d);
    insertAfter(d, 3);
    print(d);
    insertAfter(d, 5);
    print(d);
  }

  @Test
  public void testInsertBefore() {
    _DoubleNode<Integer> d = new _DoubleNode<Integer>(1);
    print(d);
    insertBefore(d, 3);
    print(d);
    insertBefore(d, 5);
    print(d);
//    1
//    3 1
//    3 5 1
  }

  @Test
  public void testRemove() {
    _DoubleNode<Integer> d = new _DoubleNode<Integer>(1);
    insertAfter(d, 2);
    insertAfter(d, 3);
    insertAtBeginning(d, 0);
    StdOut.println("init double node");
    print(d);
//    0 1 2
    StdOut.println("remove: 2");
    remove(d, 2);
    StdOut.println("remove: 0");
    remove(d, 0);
    StdOut.println("remove: 3");
    remove(d, 3);
    StdOut.println("now is list is");
    print(d);
    StdOut.println("now insert 2000, 100");
    insertAfter(d, 100);
    insertAfter(d, 2000);
    StdOut.println("remove given node d(1)");
    print(d);
    // remove at d position
    StdOut.println("after remove given node d(1)");
    print(remove(d, d));
    // given node d
    print(d);
//    init double node
//    0 1 3 2
//    remove: 2
//    remove: 0
//    remove: 3
//    now is list is
//    1
//    now insert 2000, 100
//    remove given node d
//    1 2000 100
//    after remove given node d
//    2000 100
  }
}
