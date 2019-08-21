package Ch_1_5;

import Ch_1_4._Stopwatch;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by HuGuodong on 2019-08-21.
 */
public class Ex_1_5_11 {

  public static class _WeightedQuickFindUF {

    int[] id;
    int[] sz;
    int count;

    public _WeightedQuickFindUF(int N) {
      id = new int[N];
      count = N;
      for (int i = 0; i < N; i++) {
        id[i] = i;
      }
      sz = new int[N];
      for (int i = 0; i < N; i++) {
        sz[i] = 1;
      }
    }

    public boolean connected(int p, int q) {
      return id[p] == id[q];
    }

    public int find(int p) {
      return id[p];
    }

    public void union(int p, int q) {
      int pId = id[p];
      int qId = id[q];
      if (sz[p] < sz[q]) {
        for (int i = 0; i < id.length; i++) {
          if (id[i] == pId)
            id[i] = qId;
        }
        sz[q] += sz[p];
      } else {
        for (int i = 0; i < id.length; i++) {
          if (id[i] == qId)
            id[i] = pId;
        }
        sz[p] += sz[q];
      }
      count--;
    }

    public int count() {
      return count;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("algdata/mediumUF.txt"));
    int N = StdIn.readInt();
    _WeightedQuickFindUF uf = new _WeightedQuickFindUF(N);
    _Stopwatch time = new _Stopwatch();
    while (!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (uf.connected(p, q))
        continue;
      uf.union(p, q);
      StdOut.printf("%d %d\n", p, q);
    }
    StdOut.println(uf.count() + " components, elapsed time :" + time.elapsedTime() + "s");


  }
}
