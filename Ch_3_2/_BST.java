package Ch_3_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/16.
 */

public class _BST<Key extends Comparable<Key>, Value> {

  private Node root;// root of BST

  public Value get(Key key){
    return get(root, key);
  }

  private Value get(Node x, Key key){
    if(x==null){
      return null;
    }
    int cmp = key.compareTo(x.key);
    if(cmp<0) {
      return get(x.left, key);
    }else if(cmp>0){
      return get(x.right,key);
    }else{
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

  public Key min(){
    return min(root).key;
  }

  private Node min(Node x){
    if(x.left==null) return x;
    return min(x.left);
  }

  public Key max(){
    return max(root).key;
  }

  private Node max(Node x){
    if(x.right == null) return x;
    return max(x.right);
  }

  public Key floor(Key key){
    Node x = floor(root, key);
    if(x==null){
      return null;
    }
    return x.key;
  }

  private Node floor(Node x, Key key){
    if(x==null) return null;
    int cmp = key.compareTo(x.key);
    if(cmp<0){
      return floor(x.left, key);
    }else if(cmp>0){
      Node t = floor(x.right, key); // 右子树中可能也有
      if(t!=null){
        return t;
      }else {
        return x;
      }
    }else{
      return x;
    }
  }

  public Key ceiling(Key key){
    Node x = ceiling(root, key);
    if(x==null) return null;
    return x.key;
  }

  private Node ceiling(Node x, Key key){
    if(x==null) return null;
    int cmp = key.compareTo(x.key);
    if(cmp<0){
      Node t = ceiling(x.left, key);
      if(t!=null){
        return t;
      }else{
        return x;
      }
    }else if(cmp>0){
      return ceiling(x.right,key);
    }else{
      return x;
    }
  }

  public Key select(int k){
    return select(root,k).key;
  }

  private Node select(Node x, int k){
    if(x==null) return null;
    int t = size(x.left);
    if(t>k){
      return select(x.left,k);
    }else if(t<k){
      return select(x.right,k -t-1); // 根结点+根结点左子树
    }else{
      return x;
    }
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

    for(int i=0; i<arr.length; i++){
      StdOut.print(ST.get(arr[i]));
    }
    StdOut.println();

    // min
    StdOut.println(ST.min());

    // max
    StdOut.println(ST.max());

    // floor G
    StdOut.println(ST.floor("G"));

    // ceilling G
    StdOut.println(ST.ceiling("G")); // H
    StdOut.println(ST.ceiling("B")); // C

    // select(3)
    StdOut.println(ST.select(3));

  }

}
