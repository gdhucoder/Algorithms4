package Ch_5_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.MinPQ;

/**
 * Created by HuGuodong on 2019/3/29.
 */

public class _HuffmanCompression {

  private static final int R = 256;

  private _HuffmanCompression() {}

  private static class Node implements Comparable<Node> {

    private final char ch; // used only for leaf nodes
    private final int freq; // used only for compress
    private final Node left, right;

    public Node(char ch, int freq, Node left, Node right) {
      this.ch = ch;
      this.freq = freq;
      this.left = left;
      this.right = right;
    }

    public boolean isLeaf() {
      return left == null && right == null;
    }

    public int compareTo(Node that) {
      return this.freq - that.freq;
    }
  }

  /**
   * 前序遍历
   */
  private static void writeTrie(Node x) {
    if (x.isLeaf()) {
      BinaryStdOut.write(true);
      BinaryStdOut.write(x.ch, 8);
      return;
    }
    BinaryStdOut.write(false);
    writeTrie(x.left);
    writeTrie(x.right);
  }

  /**
   * read a trie
   */
  private static Node readTire() {
    if (BinaryStdIn.readBoolean()) { // 如果是leaf
      char c = BinaryStdIn.readChar(8);
      return new Node(c, 0, null, null);
    }
    Node x = readTire();
    Node y = readTire();
    return new Node('\0', 0, x, y); // 0 used only for leaf nodes
  }

  private static Node buildTrie(int[] freq) {
    MinPQ<Node> pq = new MinPQ<>();
    for (char i = 0; i < R; i++) {
      if (freq[i] > 0) {
        pq.insert(new Node(i, freq[i], null, null));
      }
    }
    while (pq.size() > 1) {
      Node x = pq.delMin();
      Node y = pq.delMin();
      Node parent = new Node('\0', x.freq + y.freq, x, y);
      pq.insert(parent);
    }

    return pq.delMin();
  }

  /**
   * 展开
   */
  public static void expand() {
    Node root = readTire(); // read in encoding tire
    int N = BinaryStdIn.readInt(); // read the number of chars
    for (int i = 0; i < N; i++) {
      Node x = root;
      while (!x.isLeaf()) {
        if (!BinaryStdIn.readBoolean()) {
          x = x.left;
        } else {
          x = x.right;
        }
      }
      BinaryStdOut.write(x.ch);
    }
    BinaryStdOut.close();
  }

  /**
   * Building an encoding table from a (prefix-free) code trie
   */
  private static String[] buildCode(Node root) {
    String[] st = new String[R];
    buildCode(st, root, "");
    return st;
  }

  private static void buildCode(String[] st, Node x, String s) {
    if (x.isLeaf()) {
      st[x.ch] = s;
      return;
    }
    buildCode(st, x.left, s + '0');
    buildCode(st, x.right, s + '1');
  }

  public static void compress() {
    String s = BinaryStdIn.readString();
    char[] input = s.toCharArray();

    // Tabulate frequency counts
    int[] freq = new int[R];
    for (int i = 0; i < input.length; i++) {
      freq[input[i]]++;
    }

    // Build Huffman code trie
    Node root = buildTrie(freq);

    // build code table(recursive)
    String[] st = new String[R];
    buildCode(st, root, "");

    for (int i = 0; i < st.length; i++) {
      if(st[i]!=null){
        System.err.println((char)i +" : " + st[i]);
      }
    }

    // Print trie for decoder(recursive)
    writeTrie(root);

    // Print the number of chars
    BinaryStdOut.write(input.length);

    // use Huffman code to encode input
    for (int i = 0; i < input.length; i++) {
      String code = st[input[i]];
      for (int j = 0; j < code.length(); j++) {
        if (code.charAt(j) == '1') {
          BinaryStdOut.write(true);
        } else {
          BinaryStdOut.write(false);
        }
      }
    }
    BinaryStdOut.close();
  }

  public static void main(String[] args) {
    if (args[0].equals("-"))
      compress();
    else if (args[0].equals("+"))
//      return;
      expand();
    else
      throw new IllegalArgumentException("Illegal command line argument");
  }


}
