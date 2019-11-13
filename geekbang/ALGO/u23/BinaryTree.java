package geekbang.ALGO.u23;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/5/1.
 */

public class BinaryTree {

  public static class Node {

    String data;
    Node left;
    Node right;

    public Node(String data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return this.data;
    }

  }

  public static Node initTree() {
    Node node_A = new Node("A");
    Node node_B = new Node("B");
    Node node_C = new Node("C");
    Node node_D = new Node("D");
    Node node_E = new Node("E");
    Node node_F = new Node("F");
    Node node_G = new Node("G");
    node_A.left = node_B;
    node_A.right = node_C;
    node_B.left = node_D;
    node_B.right = node_E;
    node_C.left = node_F;
    node_C.right = node_G;
    return node_A;
  }

  /**
   * preorder
   */
  public static void preOrder(Node n) {
    if (n == null) {
      return;
    }
    StdOut.println(n);
    preOrder(n.left);
    preOrder(n.right);
  }

  /**
   * inorder
   */
  public static void inOrder(Node n) {
    if (n == null) {
      return;
    }
    inOrder(n.left);
    StdOut.println(n);
    inOrder(n.right);
  }

  /**
   * postorder
   */
  public static void postOrder(Node n) {
    if (n == null) {
      return;
    }
    postOrder(n.left);
    postOrder(n.right);
    StdOut.println(n);
  }

  //  先将树的根节点入队，
//
//  如果队列不空，则进入循环
//
//  {
//
//    将队首元素出队，并输出它；
//
//    如果该队首元素有左孩子，则将其左孩子入队；
//
//    如果该队首元素有右孩子，则将其右孩子入队
//
//  }
  public static void leverOrder(Node n) {
    Queue<Node> queue = new Queue<>();
    queue.enqueue(n);
    while (!queue.isEmpty()) {
      Node p = queue.dequeue();
      StdOut.println(p);
      if (p.left != null) {
        queue.enqueue(p.left);
      }
      if (p.right != null) {
        queue.enqueue(p.right);
      }
    }
  }

  public static Node tree1() {
    Node node_A = new Node("A");
    Node node_B = new Node("B");
    Node node_C = new Node("C");
    Node node_D = new Node("D");
    Node node_E = new Node("E");
    Node node_F = new Node("F");
    Node node_G = new Node("G");
    node_A.left = node_B;
    node_B.left = node_C;
    node_C.left = node_D;
    node_D.left = node_E;
    node_E.left = node_F;
    node_F.left = node_G;
    return node_A;
  }


  /**
   * get the height of a binary tree
   * @param n
   * @return
   */
  public static int height(Node n) {
    if (n == null) {
      return -1;
    }
    return Math.max(height(n.left), height(n.right)) + 1;
  }

  public static void main(String[] args) {
    Node root = initTree();
    // preOrder
    StdOut.println("PRE ORDER ===========================");
    preOrder(root);
    // inOrder
    StdOut.println("IN ORDER ===========================");
    inOrder(root);
    // postOrder
    StdOut.println("POST ORDER ===========================");
    postOrder(root);
    // levelOrder
    StdOut.println("LEVEL ORDER ===========================");
    leverOrder(root);

    int height = height(tree1());
    StdOut.println(height);

  }


}
