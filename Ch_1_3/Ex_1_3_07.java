package Ch_1_3;

/**
 * Created by HuGuodong on 2019/7/5.
 */

public class Ex_1_3_07 {

  public static void main(String[] args) {
    _Stack<Integer> s = new _Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    assert s.peek() == 4; // pass
  }
}
