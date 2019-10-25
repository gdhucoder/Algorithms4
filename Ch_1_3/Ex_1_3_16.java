package Ch_1_3;


import static tools.Constant.getCurDir;

import Ch_1_2.Ex_1_2_12._SmartDate;
import edu.princeton.cs.algs4.In;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/16.
 */

public class Ex_1_3_16 {

  public static _SmartDate[] readDates(String name) {
    In in = new In(name);
    _Queue<String> q = new _Queue<>();
    while (!in.isEmpty()) {
      q.enqueue(in.readString());
    }
    int N = q.size();
    _SmartDate[] dates = new _SmartDate[N];
    for (int i = 0; i < N; i++) {
//      dates[i] = new _SmartDate(q.dequeue());
    }
    return dates;
  }

  public static void main(String[] args) {
    _SmartDate[] dates = readDates(getCurDir("Ch_1_3/Ex_1_3_16.txt"));
    PrintUtil.show(dates);
//    _SmartDate{year=2019, month=7, day=16} _SmartDate{year=2019, month=8, day=9}
  }
}
