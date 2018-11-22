package Ch_3_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/22.
 */

public class Ex_3_1_25 {

  static class SequentialSearchST<Key extends Comparable<Key>, Value> {

    private Node first;
    private Node cache;
    private int size;

    SequentialSearchST() {
    }

    public void put(Key key, Value val) {

      if (key == null) {
        return;
      }

      if (isEmpty()) {
        first = new Node(key, val, null);
        cache = first;
        size++;
        return;
      }

      if (val == null) {
        delete(key);
        return;
      }

      if (cache != null && cache.key.compareTo(key) == 0) {
        StdOut.print("hit cache: " + key.toString() + "\t");
        cache.val = val;
        return;
      }

      Node pre = null;

      for (Node x = first; x != null; x = x.next) {
        if (key.compareTo(x.key) == 0) {
          x.val = val;
          cache = x;
          return;
        }
        pre = x;
      }

      pre.next = new Node(key, val, null);
      cache = pre.next;
      size++;
    }


    public Value get(Key key) {
      if (isEmpty()) {
        throw new IllegalArgumentException("empty ST!");
      }

      if (cache != null && cache.key.compareTo(key) == 0) {
        StdOut.print("hit cache: " + key.toString() + "\t");
        return cache.val;
      }

      for (Node x = first; x != null; x = x.next) {
        if (key.compareTo(x.key) == 0) {
          cache = x;
          return x.val;
        }
      }
      return null;
    }

    public void delete(Key key) {

      if (key == null) {
        return;
      }

      if (isEmpty()) {
        throw new IllegalArgumentException("empty ST!");
      }

      if (cache != null && cache.key.compareTo(key) == 0) {
        cache = null;
        StdOut.println("clear cache");
      }

      if (size() == 1) {
        if (first.key.compareTo(key) == 0) {
          first = null;
          size--;
          return;
        }
      }

      Node cur, pre;
      for (pre = first, cur = first.next;
            cur != null;
            cur = cur.next, pre = pre.next) {
        if (key.compareTo(cur.key) == 0) {
          pre.next = pre.next.next;
          size--;
          return;
        }
      }

    }


    public boolean isEmpty() {
      return size == 0;
    }

    public int size() {
      return size;
    }


    private class Node {

      Key key;
      Value val;
      Node next;

      Node(Key key, Value val, Node next) {
        this.key = key;
        this.val = val;
        this.next = next;
      }
    }
  }

  public static void main(String[] args) {

    String[] a = "A B C D E F G".split(" ");
    SequentialSearchST<String, Integer> st = new SequentialSearchST<>();

    for (int i = 0; i < a.length; i++) {
      st.put(a[i], i);
    }

    for (int i = 0; i < a.length; i++) {
      StdOut.println(st.get(a[i]));
      StdOut.println(st.get(a[i]));
    }

    st.put("A", 1);
    st.put("A", 3);
    StdOut.println(st.get("A"));

  }
}
