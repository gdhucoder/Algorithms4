package Ch_1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-08-19.
 */
public class Ex_1_5_01 {
  public static class _QuickFindUFCost{
    private int[]id;
    private int count;
    private int arrayAccess;
    public _QuickFindUFCost(int N){
      id = new int[N];
      for (int i = 0; i < N; i++) {
        id[i] = i;
        count=N;
      }
    }
    public void union(int p, int q){
      int pId = find(p);
      int qId = find(q);
      for (int i = 0; i < id.length; i++) {
        if(id[i] == pId){
          id[i] = qId;
          arrayAccess++;
        }
        arrayAccess++;
      }
      count--;

      StdOut.printf("union(%d,%d):\t", p, q);
      PrintUtil.show(id, '\t');
      StdOut.printf("array access count: %4d\n", arrayAccess);
    }
    public int find(int p){
      arrayAccess++;
      return id[p];
    }
    public boolean connected(int p, int q){
      return find(p) == find(q);
    }
    public int count(){
      return count;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("Ch_1_5/Ex_1_5_01.txt"));
    int N = StdIn.readInt();
    _QuickFindUFCost uf = new _QuickFindUFCost(10);
    while (!StdIn.isEmpty()){
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      uf.union(p,q);
    }
//    union(9,0):	0 1 2 3 4 5 6 7 8 0 	array access count:   13
//    union(3,4):	0 1 2 4 4 5 6 7 8 0 	array access count:   26
//    union(5,8):	0 1 2 4 4 8 6 7 8 0 	array access count:   39
//    union(7,2):	0 1 2 4 4 8 6 2 8 0 	array access count:   52
//    union(2,1):	0 1 1 4 4 8 6 1 8 0 	array access count:   66
//    union(5,7):	0 1 1 4 4 1 6 1 1 0 	array access count:   80
//    union(0,3):	4 1 1 4 4 1 6 1 1 4 	array access count:   94
//    union(4,2):	1 1 1 1 1 1 6 1 1 1 	array access count:  110

  }
}
