package Ch_1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by HuGuodong on 2019-08-18.
 */
public class _QuickUnionUF {

  int[] id;
  int count;

  public _QuickUnionUF(int N) {
    id = new int[N];
    count = N;
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }


  private int root(int i) {
    while (i != id[i]) {
      i = id[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int pRoot = root(p);
    int qRoot = root(q);
    id[pRoot] = qRoot;
    count--;
  }

  public int count() {
    return count;
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("algdata/mediumUF.txt"));
    int N = StdIn.readInt();
    _QuickUnionUF uf = new _QuickUnionUF(N);
    while (!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (uf.connected(p, q))
        continue;
      uf.union(p, q);
      StdOut.printf("%d %d\n", p, q);
    }
    StdOut.println(uf.count() + " components");
  }

}
