package Ch_4_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by HuGuodong on 2018/12/11.
 */

public class _DepthFirstOrder {

  private boolean[] marked;
  private Queue<Integer> pre; // vertices in preorder
  private Queue<Integer> post; // vertices in postorder
  private Stack<Integer> reversePost; // vertices in reverse postorder

  public _DepthFirstOrder(_Digraph G) {
    pre = new Queue<>();
    post = new Queue<>();
    reversePost = new Stack<>();
    marked = new boolean[G.V()];
    for (int v = 0; v < G.V(); v++)
      if (!marked[v])
        dfs(G, v);
  }

  private void dfs(_Digraph G, int v) {
    pre.enqueue(v);

    marked[v] = true;
    for (int w : G.adj(v))
      if (!marked[w])
        dfs(G, w);

    post.enqueue(v);
    reversePost.push(v);
  }

  public Iterable<Integer> pre() {
    return pre;
  }

  public Iterable<Integer> post() {
    return post;
  }

  public Iterable<Integer> reversePost() {
    return reversePost;
  }


}
