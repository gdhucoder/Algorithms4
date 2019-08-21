package Ch_1_5;

import Ch_1_4._Stopwatch;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;

/**
 * Created by HuGuodong on 2019-08-16.
 */
public class _QuickFindUF {

  int[] id; // access to component id (site indexed)
  int count; // number of components

  /**
   * initialize N sites with integer names(0 to N-1)
   *
   * @param N
   */
  public _QuickFindUF(int N) {
    count = N;
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  /**
   * add all connection between p and q
   *
   * @param p
   * @param q
   */
  public void union(int p, int q) {
    int pID = find(p);
    int qID = find(q);
    if(pID == qID)
      return;
    for (int i = 0; i < id.length; i++) {
      if(id[i] == pID)
        id[i] = qID;
    }
    count--;
//    PrintUtil.show(id);
  }

  /**
   * component identifier for p(0~N-1)
   *
   * @param p
   * @return
   */
  public int find(int p) {
    return id[p];
  }

  /**
   * return true if p and q are in the same component
   *
   * @param p
   * @param q
   * @return
   */
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  /**
   * number of components
   *
   * @return
   */
  public int count() {
    return count;
  }

  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("algdata/mediumUF.txt"));
    int N = StdIn.readInt();
    _QuickFindUF uf = new _QuickFindUF(N);
    _Stopwatch time = new _Stopwatch();
    while (!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (uf.connected(p, q))
        continue;
      uf.union(p, q);
      StdOut.printf("%d %d\n", p, q);
    }
    StdOut.println(uf.count() + " components, elapsed time :" + time.elapsedTime() +"s");
  }
}
