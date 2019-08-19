package Ch_1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-08-20.
 */
public class Ex_1_5_03 {

  public static class _WeightedQuickUnion {

    private int[] id;
    private int[] sz;
    private int count;

    private int arrayAccess;
    private int totalArrayAccess;

    public _WeightedQuickUnion(int N) {
      id = new int[N];
      sz = new int[N];
      count = N;
      for (int i = 0; i < N; i++) {
        id[i] = i;
        sz[i] = 1;
      }
    }

    public int root(int p) {
      while (true) {
        arrayAccess++;
        if (p != id[p]) {// compare  + 1
          arrayAccess++;
          p = id[p];// p points to parent of p
        } else {
          break;
        }
      }
      return p;
    }

    public boolean connected(int p, int q) {
      return root(p) == root(q);
    }

    public void union(int p, int q) {
      int pRoot = root(p);
      int qRoot = root(q);
      arrayAccess += 2;// compare
      if (sz[pRoot] < sz[qRoot]) { // make smaller root point to larger one
        id[pRoot] = qRoot;
        sz[qRoot] += sz[pRoot];
      } else {
        id[qRoot] = pRoot;
        sz[pRoot] += sz[qRoot];
      }
      arrayAccess += 4;// change id 1, plus sz = sz + sz .. 3
      totalArrayAccess += arrayAccess;
      StdOut.printf("union(%d,%d):\t", p, q);
      PrintUtil.show(id, '\t');
      StdOut.printf("array access count: %4d, total: %4d\n", arrayAccess, totalArrayAccess);
      arrayAccess = 0;
      count--;
    }

    public int count() {
      return count;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("Ch_1_5/Ex_1_5_01.txt"));
    int N = StdIn.readInt();
    _WeightedQuickUnion uf = new _WeightedQuickUnion(N);
    while (!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
//        if(uf.connected(p,q))
//          continue;
//        StdOut.printf("%d %d\n", p, q);
      uf.union(p, q);
    }

    StdOut.println(uf.count() + " components");
//    union(9,0):	9 1 2 3 4 5 6 7 8 9 	array access count:    8, total:    8
//    union(3,4):	9 1 2 3 3 5 6 7 8 9 	array access count:    8, total:   16
//    union(5,8):	9 1 2 3 3 5 6 7 5 9 	array access count:    8, total:   24
//    union(7,2):	9 1 7 3 3 5 6 7 5 9 	array access count:    8, total:   32
//    union(2,1):	9 7 7 3 3 5 6 7 5 9 	array access count:   10, total:   42
//    union(5,7):	9 7 7 3 3 7 6 7 5 9 	array access count:    8, total:   50
//    union(0,3):	9 7 7 9 3 7 6 7 5 9 	array access count:   10, total:   60
//    union(4,2):	9 7 7 9 3 7 6 7 5 7 	array access count:   14, total:   74
//    2 components

  }
}
