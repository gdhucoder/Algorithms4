package Ch_1_5;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-08-21.
 */
public class Ex_1_5_08 {

  public static class _CounterExampleQuickFindUF extends _QuickFindUF {

    public _CounterExampleQuickFindUF(int N) {
      super(N);
    }



    public void badUnion(int p, int q) {
      if (connected(p, q))
        return;
      for (int i = 0; i < id.length; i++) {
        // in this implementation, for r > p, the id[d] will not change
        if (id[i] == id[p])
          id[i] = id[q];
      }
      PrintUtil.show(id);
      count--;
    }

    @Override
    public void union(int p,int q){
      super.union(p,q);
      PrintUtil.show(id);
    }
  }

  public static void main(String[] args) {
    _CounterExampleQuickFindUF uf = new _CounterExampleQuickFindUF(10);
    uf.badUnion(4, 3);
    uf.badUnion(3, 8);
    _CounterExampleQuickFindUF uf2 = new _CounterExampleQuickFindUF(10);
    uf2.union(4,3);
    uf2.union(3,8);
//    0 1 2 3 3 5 6 7 8 9
//    0 1 2 8 3 5 6 7 8 9
//    0 1 2 3 3 5 6 7 8 9
//    0 1 2 8 8 5 6 7 8 9
  }
}
