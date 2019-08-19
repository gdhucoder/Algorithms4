package Ch_1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by HuGuodong on 2019-08-20.
 */
public class _WeightedQuickUnion {
  private int[] id;
  private int[] sz;
  private int count;
  public _WeightedQuickUnion(int N){
    id = new int[N];
    sz = new int[N];
    count = N;
    for (int i = 0; i < N; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  public int root(int p){
    while (p!=id[p]){
      p = id[p];
    }
    return p;
  }

  public boolean connected(int p, int q){
    return root(p) == root(q);
  }

  public void union(int p, int q){
    int pRoot = root(p);
    int qRoot = root(q);
    if(sz[pRoot]<sz[qRoot]){ // make smaller root point to larger one
      id[pRoot] = qRoot;
      sz[qRoot] += sz[pRoot];
    }else {
      id[qRoot] = pRoot;
      sz[pRoot] += sz[qRoot];
    }
    count--;
  }

  public int count(){
    return count;
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("algdata/largeUF.txt"));
    int N = StdIn.readInt();
    _WeightedQuickUnion uf = new _WeightedQuickUnion(N);
    while (!StdIn.isEmpty()){
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if(uf.connected(p,q))
        continue;
      StdOut.printf("%d %d\n", p, q);
      uf.union(p,q);
    }

    StdOut.println(uf.count() +" components");

  }
}
