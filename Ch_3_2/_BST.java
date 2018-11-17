package Ch_3_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * Created by HuGuodong on 2018/11/16.
 */

public class _BST<Key extends Comparable<Key>, Value> {

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
    x.size = size(x.left) + size(x.right) + 1;
    return x;
  }

  public Key min() {
    return min(root).key;
  }

  private Node min(Node x) {
    if (x.left == null) {
      return x;
    }
    return min(x.left);
  }

  public Key max() {
    return max(root).key;
  }

  private Node max(Node x) {
    if (x.right == null) {
      return x;
    }
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
    if (x == null) {
      return null;
    }
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
    if (x == null) {
      return null;
    }
    return x.key;
  }

  private Node ceiling(Node x, Key key) {
    if (x == null) {
      return null;
    }
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
    if (x == null) {
      return null;
    }
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
    if (x == null) {
      return 0;
    }
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
    if (x.left == null) {
      return x.right;
    }
    x.left = deleteMin(x.left);
    x.size = size(x.left) + size(x.right) + 1;
    return x;
  }

  public void deleteMax() {
    root = deleteMax(root);
  }

  private Node deleteMax(Node x) {
    if (x.right == null) {
      return x.left;
    }
    x.right = deleteMax(x.right);
    x.size = size(x.left) + size(x.right) + 1;
    return x;
  }

  public void delete(Key key) {
    root = delete(root, key); // 重新让根结点指向新的根结点
  }

  private Node delete(Node x, Key key) {
    if (x == null) {
      return null;
    }
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      x.left = delete(x.left, key);
    } else if (cmp > 0) {
      x.right = delete(x.right, key);
    } else {
      if (x.right == null) {
        return x.left;
      }
      if (x.left == null) {
        return x.right;
      }
      Node t = x;
      x = min(x.right);
      x.right = deleteMin(t.right);
      x.left = t.left;
    }
    x.size = size(x.left) + size(x.right) + 1; // 更新结点数目
    return x;
  }

  public Iterable<Key> keys() {
    if (isEmpty()) {
      return new Queue<Key>();
    }
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
    if (x == null) {
      return;
    }
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


  public int size() {
    return size(root);
  }

  private int size(Node x) {
    if (x == null) {
      return 0;
    } else {
      return x.size;
    }
  }

  public int size(Key lo, Key hi) {
    if (lo == null) {
      throw new IllegalArgumentException("first argument is null");
    }
    if (hi == null) {
      throw new IllegalArgumentException("second argument is null");
    }

    if (lo.compareTo(hi) > 0) {
      return 0;
    }

    if (contains(hi)) {
      return rank(hi) - rank(lo) + 1;
    } else {
      return rank(hi) - rank(lo);
    }


  }

  public boolean contains(Key key) {
    return get(key) != null;
  }

  public boolean isEmpty() {
    return size(root) == 0;
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

  public class Node {

    private Key key;
    private Value val;
    private Node left, right;
    private int size; // # nodes in subtree rooted here

    public Node(Key key, Value val, int size) {
      this.key = key;
      this.val = val;
      this.size = size;
    }

    @Override
    public String toString() {
      return String
          .format("{key: %s, value: %s, size: %d}", this.key.toString(), this.val.toString(), this.size);
    }
  }

  public static void main(String[] args) {
    String str = "S E A R C H E X";
    String[] arr = str.split(" ");

    _BST<String, Integer> ST = new _BST<>();

    for (int i = 0; i < arr.length; i++) {
      ST.put(arr[i], i);
    }

    for (int i = 0; i < arr.length; i++) {
      StdOut.print(ST.get(arr[i]));
    }
    StdOut.println();

    StdOut.println("===============================================");
    StdOut.println("按顺序输出");

    ST.print();

    StdOut.println("===============================================");
    StdOut.println("Keys:");

    Iterable keys = ST.keys("B", "G");

    for (Object key : keys) {
      StdOut.println(key);
    }
    StdOut.println("===============================================");
    // min
    StdOut.println("min: " + ST.min());

    // max
    StdOut.println(ST.max());

    // floor G
    StdOut.println(ST.floor("G"));

    // ceilling G
    StdOut.println(ST.ceiling("G")); // H
    StdOut.println(ST.ceiling("B")); // C

    // select(3)
    StdOut.println(ST.select(3));

    StdOut.println(ST.rank("G")); // 3
    StdOut.println(ST.rank("E")); // 2

    for (int i = 0; i < arr.length; i++) {
      StdOut.print(ST.get(arr[i]));
    }
    StdOut.println();

    // min
    StdOut.println("min:" + ST.min());
    StdOut.println("max:" + ST.max());

    ST.deleteMin();

    ST.deleteMax();

    // min
    StdOut.println("min:" + ST.min());

    // max
    StdOut.println("max:" + ST.max());

    StdOut.println("===============================================");
    StdOut.println("按顺序输出");

    ST.print();

    StdOut.println("===============================================");

    // 删除
    ST.delete("C");
    ST.delete("E");
    ST.delete("R");
    StdOut.println("删除后；");

    StdOut.println("===============================================");
    StdOut.println("按顺序输出");

    ST.print();

    StdOut.println("===============================================");

  }

}
