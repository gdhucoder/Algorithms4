package Ch_3_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/17.
 */

public class Ex_3_2_06 {

  static class _BST<Key extends Comparable<Key>, Value> {

    private Node root;// root of BST

    public Value get(Key key) {
      return get(root, key);
    }

    private Value get(Node x, Key key) {
      if (x == null) {
        return null;
      }
      int cmp = key.compareTo(x.key);
      if (cmp < 0) {
        return get(x.left, key);
      } else if (cmp > 0) {
        return get(x.right, key);
      } else {
        return x.val;
      }
    }

    public void put(Key key, Value val) {
      root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
      if (x == null) {
        return new Node(key, val, 1);
      }
      int cmp = key.compareTo(x.key);
      if (cmp < 0) {
        x.left = put(x.left, key, val);
      } else if (cmp > 0) {
        x.right = put(x.right, key, val);
      } else {
        x.val = val;
      }
      x.N = size(x.left) + size(x.right) + 1;
      return x;
    }

    public Key min() {
      return min(root).key;
    }

    private Node min(Node x) {
      if (x.left == null)
        return x;
      return min(x.left);
    }

    public Key max() {
      return max(root).key;
    }

    private Node max(Node x) {
      if (x.right == null)
        return x;
      return max(x.right);
    }

    public Key floor(Key key) {
      Node x = floor(root, key);
      if (x == null) {
        return null;
      }
      return x.key;
    }

    private Node floor(Node x, Key key) {
      if (x == null)
        return null;
      int cmp = key.compareTo(x.key);
      if (cmp < 0) {
        return floor(x.left, key);
      } else if (cmp > 0) {
        Node t = floor(x.right, key); // 右子树中可能也有
        if (t != null) {
          return t;
        } else {
          return x;
        }
      } else {
        return x;
      }
    }

    public Key ceiling(Key key) {
      Node x = ceiling(root, key);
      if (x == null)
        return null;
      return x.key;
    }

    private Node ceiling(Node x, Key key) {
      if (x == null)
        return null;
      int cmp = key.compareTo(x.key);
      if (cmp < 0) {
        Node t = ceiling(x.left, key);
        if (t != null) {
          return t;
        } else {
          return x;
        }
      } else if (cmp > 0) {
        return ceiling(x.right, key);
      } else {
        return x;
      }
    }

    public Key select(int k) {
      return select(root, k).key;
    }

    private Node select(Node x, int k) {
      if (x == null)
        return null;
      int t = size(x.left);
      if (t > k) {
        return select(x.left, k);
      } else if (t < k) {
        return select(x.right, k - t - 1); // 根结点+根结点左子树
      } else {
        return x;
      }
    }

    public int rank(Key key) {
      return rank(root, key);
    }

    private int rank(Node x, Key key) {
      if (x == null)
        return 0;
      int cmp = key.compareTo(x.key);
      if (cmp < 0) {
        return rank(x.left, key);
      } else if (cmp > 0) {
        return 1 + size(x.left) + rank(x.right, key); // 根结点 + 左子树 + 右子树中的rank
      } else {
        return size(x.left);
      }
    }

    public void deleteMin() {
      root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
      if (x.left == null)
        return x.right;
      x.left = deleteMin(x.left);
      x.N = size(x.left) + size(x.right) + 1;
      return x;
    }

    public void deleteMax() {
      root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
      if (x.right == null)
        return x.left;
      x.right = deleteMax(x.right);
      x.N = size(x.left) + size(x.right) + 1;
      return x;
    }

    public void delete(Key key) {
      delete(root, key);
    }

    private Node delete(Node x, Key key) {
      if (x == null)
        return null;
      int cmp = key.compareTo(x.key);
      if (cmp < 0) {
        x.left = delete(x.left, key);
      } else if (cmp > 0) {
        x.right = delete(x.right, key);
      } else {
        if (x.right == null)
          return x.left;
        if (x.left == null)
          return x.right;
        Node t = x;
        x = min(x.right);
        x.right = deleteMin(t.right);
        x.left = t.left;
      }
      x.N = size(x.left) + size(x.right) + 1; // 更新结点数目
      return x;
    }

    public Iterable<Key> keys() {
      return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
      Queue<Key> queue = new Queue<>();
      keys(root, queue, lo, hi);
      return queue;
    }

    /**
     * 中序遍历
     */
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
      if (x == null)
        return;
      int cmplo = lo.compareTo(x.key);
      int cmphi = hi.compareTo(x.key);
      if (cmplo < 0) {
        keys(x.left, queue, lo, hi);
      }
      if (cmplo <= 0 && cmphi >= 0) {
        queue.enqueue(x.key);
      }
      if (cmphi > 0) {
        keys(x.right, queue, lo, hi);
      }
    }


    public int height(){
      return height(root);
    }

//    private int height(Node x){
//      if(x==null) return 0;
//      int heightLeft = 0;
//      int heightRight = 0;
//      if(x.left!=null){
//        heightLeft = height(x.left);
//      }
//      if(x.right!=null){
//        heightRight = height(x.right);
//      }
//      return heightLeft>heightRight? heightLeft+1:heightRight+1;
//    }

    private int height(Node x){
      if(x==null) return -1;
      return 1 + Math.max(height(x.left), height(x.right));
    }


    public int size() {
      return size(root);
    }

    private int size(Node x) {
      if (x == null) {
        return 0;
      } else {
        return x.N;
      }
    }

    public void print() {
      print(root);
    }

    private void print(Node x) {
      if (x == null)
        return;
      print(x.left);
      StdOut.println(x.key);
      print(x.right);

    }

    private class Node {

      private Key key;
      private Value val;
      private Node left, right;
      private int N; // # nodes in subtree rooted here

      public Node(Key key, Value val, int N) {
        this.key = key;
        this.val = val;
        this.N = N;
      }

      @Override
      public String toString() {
        return String
            .format("{key: %s, value: %s, N: %d}", this.key.toString(), this.val.toString(),
                this.N);
      }
    }
  }

  /**
   * 递归时间线性级别，空间为树的高度
   * @param args
   */
  public static void main(String[] args) {
    String str = "H C S A E X R";
    String[] arr = str.split(" ");

    _BST<String,Integer> ST = new _BST<>();

    for(int i=0; i<arr.length; i++){
      ST.put(arr[i], i);
    }

    StdOut.println(ST.height());

    str = "A B C D E F G";
    arr = str.split(" ");
    ST = new _BST<>();

    for(int i=0; i<arr.length; i++){
      ST.put(arr[i], i);
    }

    StdOut.println(ST.height());
  }

}
