package Ch_1_2;

import Ch_1_2.Ex_1_2_12._SmartDate;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/6/22.
 */

public class Ex_1_2_13 {

  public static class _Transaction implements Comparable<_Transaction> {

    private String who;
    private _SmartDate when;
    private double amount;

    public _Transaction(String who, _SmartDate when, double amount) {
      this.who = who;
      this.when = when;
      this.amount = amount;
    }

    /**
     * parse constructor NAME 2002/02/02 100.0
     */
    public _Transaction(String transaction) {
      String[] param = transaction.split(" ");
      if (param.length != 3) {
        throw new IllegalArgumentException("wrong format!");
      }
      who = param[0];
      String[] dateStrs = param[1].split("/");
      int y = Integer.parseInt(dateStrs[0]);
      int m = Integer.parseInt(dateStrs[1]);
      int d = Integer.parseInt(dateStrs[2]);
      when = new _SmartDate(y, m, d);
      amount = Double.parseDouble(param[2]);
    }

    public String who() {
      return who;
    }

    public _SmartDate when() {
      return when;
    }

    public double amount() {
      return amount;
    }


    @Override
    public int compareTo(_Transaction o) {
      return 0;
    }

    @Override
    public String toString() {
      return "_Transaction{" +
          "who='" + who + '\'' +
          ", when=" + when +
          ", amount=" + amount +
          '}';
    }
  }

  public static void main(String[] args) {
    _Transaction t1 = new _Transaction("huguodong 2019/06/22 100.12");
    StdOut.println(t1);
    _Transaction t2 = new _Transaction("tw", new _SmartDate(2020, 10, 10), 99999);
    StdOut.println(t2);
//    _Transaction{who='huguodong', when=_SmartDate{year=2019, month=6, day=22}, amount=100.12}
//    _Transaction{who='tw', when=_SmartDate{year=2020, month=10, day=10}, amount=99999.0}
  }
}
