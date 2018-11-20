package Ch_3_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/17.
 */

public class Ex_3_2_13 {

  static class _NonRecursiveBST<Key extends Comparable<Key>, Value> {

    private Node root;// root of BST

    public Value get(Key key) {
      Node x = root;
      while (x != null) {
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
          return x.val;
        } else if (cmp < 0) {
          x = x.left;
        } else {
          x = x.right;
        }
      }
      return null;
    }

    public void put(Key key, Value val) {
      Node x = root;
      Node z = new Node(key, val);

      if (x == null) {
        root = z;
        return;
      }

      Node parent = null;
      while (x != null) {
        parent = x;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
          x.val = val;
        } else if (cmp < 0) {
          x = x.left;
        } else {
          x = x.right;
        }
      }

      int cmp = key.compareTo(parent.key);
      if (cmp < 0) {
        parent.left = z;
      } else {
        parent.right = z;
      }
    }


    public Iterable<Key> keys() {
      Stack<Node> stack = new Stack<>();
      Queue<Key> queue = new Queue<>();
      Node x = root;
      while (x != null || !stack.isEmpty()) {
        if (x != null) {
          stack.push(x);
          x = x.left;
        } else {
          x = stack.pop();
          queue.enqueue(x.key);
          x = x.right;
        }
      }

      return queue;
    }


    public void print() {
      print(root);
    }

    private void print(Node x) {
      if (x == null) {
        return;
      }
      print(x.left);
      StdOut.println(x.key);
      print(x.right);

    }

    private class Node {

      private Key key;
      private Value val;
      private Node left, right;

      public Node(Key key, Value val) {
        this.key = key;
        this.val = val;
      }

      @Override
      public String toString() {
        return String
            .format("{key: %s, value: %s }", this.key.toString(), this.val.toString());
      }
    }
  }


  /**
   * 使用非递归实现 get put keys
   * @param args
   */
  public static void main(String[] args) {
    String str = "H C S A E X R";
    String[] arr = str.split(" ");

    _NonRecursiveBST<String, Integer> ST = new _NonRecursiveBST<>();

    for (int i = 0; i < arr.length; i++) {
      ST.put(arr[i], i);
    }

    for (String key : ST.keys()) {
      StdOut.println(key + ":" + ST.get(key));
    }

//    A:3
//    C:1
//    E:4
//    H:0
//    R:6
//    S:2
//    X:5


  }
}
