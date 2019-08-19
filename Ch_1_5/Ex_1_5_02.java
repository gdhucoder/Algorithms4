package Ch_1_5;

import Ch_1_5.Ex_1_5_01._QuickFindUFCost;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by HuGuodong on 2019-08-19.
 */
public class Ex_1_5_02 {
  public static class _QuickUnionUF{
    private int[] id;
    private int count;
    private int arrayAccess;
    public _QuickUnionUF(int N){
      id = new int[N];
      count = N;
      for (int i = 0; i < N; i++) {
        id[i] = i;
      }
    }

    public int root(int p){
      arrayAccess++;
      while (id[p]!=p){
        arrayAccess++;
        p = id[p];
      }
      return p;
    }

    public void union(int p, int q){
      int i = root(p);
      int j = root(q);
      if(i==j)
        return;
      id[i] = j;
      arrayAccess++;
      count--;
    }

    public boolean connected(int p, int q){
      return root(p) == root(q);
    }

    public int count(){
      return count;
    }
    public int arrayAccess(){
      return arrayAccess;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("Ch_1_5/Ex_1_5_01.txt"));
    int N = StdIn.readInt();
    _QuickUnionUF uf = new _QuickUnionUF(N);
    while (!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      uf.union(p, q);
    }
    StdOut.println(uf.arrayAccess());
  }
}
