package ALeetCode.comp.p193;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class TreeAncestor {

  int n;
  Pair[] parents;

  public TreeAncestor(int n, int[] parent) {
    this.n = n;
    parents = new Pair[n];
    for (int i = 0; i < n; i++) {
      parents[i] = new Pair(parent[i], 1);
    }
  }

  public int getKthAncestor(int node, int k) {
    int cnt = 0;
    int temp = node;
    int last = 0;
    while (node != -1 && cnt < k) {
      last = parents[node].steps;
      cnt += last;
      node = parents[node].parent;
    }
    if (cnt < k) {
      parents[temp].parent = 0;
      parents[temp].steps = cnt - last;
    }
    return node;
  }

  private class Pair {

    int parent;
    int steps;

    Pair(int p, int s) {
      parent = p;
      steps = s;
    }
  }

  public static void main(String[] args) {
    int[] a = {-1, 0, 0, 1, 2};
    TreeAncestor t = new TreeAncestor(5, a);
    //    int res = t.getKthAncestor(3,1);
    //    System.out.println(res);
    //    System.out.println(t.getKthAncestor(5, 2));
    System.out.println(t.getKthAncestor(3, 5));
    System.out.println(t.getKthAncestor(3, 2));
    System.out.println();
  }
}
