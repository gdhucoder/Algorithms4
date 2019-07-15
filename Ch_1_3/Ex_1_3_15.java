package Ch_1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/16.
 */

public class Ex_1_3_15 {

  public static void printKthInput() {
    int k = StdIn.readInt();
    _Queue<String> q = new _Queue<>();
    while (!StdIn.isEmpty()) {
      q.enqueue(StdIn.readString());
    }
    int pos = q.size() - k;
    int cnt = 0;
    while (cnt < pos) {
      q.dequeue();
      cnt++;
    }
    StdOut.println(q.dequeue());
  }

  public static void main(String[] args) {
    printKthInput();
  }
}
