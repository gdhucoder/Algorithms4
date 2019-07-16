package Ch_1_3;

import static tools.Constant.getCurDir;

import Ch_1_2.Ex_1_2_13._Transaction;
import edu.princeton.cs.algs4.In;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/17.
 */

public class Ex_1_3_17 {

  public static _Transaction[] readTransations(String name) {
    In in = new In(name);
    _Queue<String> q = new _Queue<>();
    while (!in.isEmpty()) {
      q.enqueue(in.readLine());
    }
    int N = q.size();
    _Transaction[] trans = new _Transaction[N];
    for (int i = 0; i < N; i++) {
      trans[i] = new _Transaction(q.dequeue());
    }
    return trans;
  }

  public static void main(String[] args) {
//    huguodong 2019/06/22 100.12
//    huguodong 2019/06/23 9998.12

    _Transaction[] trans = readTransations(getCurDir("Ch_1_3/Ex_1_3_17.txt"));
    PrintUtil.show(trans, '\n');
//    _Transaction{who='huguodong', when=_SmartDate{year=2019, month=6, day=22}, amount=100.12}
//    _Transaction{who='huguodong', when=_SmartDate{year=2019, month=6, day=23}, amount=9998.12}
  }
}
