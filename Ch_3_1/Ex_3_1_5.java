package Ch_3_1;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by HuGuodong on 2018/11/11.
 */

public class Ex_3_1_5 {

  static class _SequentialSearchST<Key, Value> {

    private Node first;
    private int n; // size;

    class Node {

      Node() {

      }

      Node(Key key, Value value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
      }

      Key key;
      Value value;
      Node next;
    }

    public void put(Key key, Value value) {

      if (key == null) {
        throw new IllegalArgumentException("argument put() is null");
      }

      if (value == null) {
        delete(key);
      }

      for (Node node = first; node != null; node = node.next) {
        if (node.key.equals(key)) {
          node.value = value;
          return;
        }
      }

      first = new Node(key, value, first);
      n++;

    }

    public Value get(Key key) {
      if (key == null) {
        throw new IllegalArgumentException("argument get() is null");
      }

      for (Node n = first; n != null; n = n.next) {
        if (n.key.equals(key)) { // equals 表示等于， == 表示引用
          return n.value;
        }
      }

      return null;

    }

    public void delete(Key key) {
      if (key == null) {
        throw new IllegalArgumentException("argument delete() is null");
      }
      first = delete(first, key);
    }


    /**
     * 删除链表中以node为起始中的key
     */
    private Node delete(Node node, Key key) {
      if (node == null) {
        return null;
      }

      if (key.equals(node.key)) {
        n--;
        return node.next;
      }
      node.next = delete(node.next, key);
      return node;
    }

    public boolean contains(Key key) {
      if (key == null) {
        throw new IllegalArgumentException("argument contains() is null");
      }
      return get(key) != null;
    }

    public int containsCounts(Key key) {
      int count = 0;
      for (Node n = first; n != null; n = n.next) {
        if (n.key.equals(key)) { // equals 表示等于， == 表示引用
          return count;
        }
        count++;
      }

      return count;
    }

    public boolean isEmpty() {
      return first == null;
    }

    public int size() {
      return n;
    }

    public Iterable<Key> keys() {
      Queue queue = new Queue();
      Node node = first;
      while (node != null) {
        queue.enqueue(node.key);
        node = node.next;
      }
      return queue;
    }

  }

}
