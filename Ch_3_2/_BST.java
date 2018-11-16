package Ch_3_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/16.
 */

public class _BST<Key extends Comparable<Key>, Value> {

  private Node root;// root of BST

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


  public int size(){
    return size(root);
  }

  private int size(Node x){
    if(x==null){
      return 0;
    }else{
      return x.N;
    }
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
      return String.format("{key: %s, value: %s, N: %d}", this.key.toString(), this.val.toString(),this.N);
    }
  }

  public static void main(String[] args) {
    String str = "S E A R C H E X";
    String[] arr = str.split(" ");
    _BST<String,Integer> ST = new _BST<>();
    for(int i=0; i<arr.length; i++){
      ST.put(arr[i], i);
    }
  }

}
