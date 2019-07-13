package Ch_1_3;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/13.
 */

public class Ex_1_3_12 {


  public static _Stack<String> copyStack(_Stack<String> stack) {
    if (stack == null) {
      throw new IllegalArgumentException("stack is null");
    }
    _Stack<String> another = new _Stack<>();
    for (String s : stack) {
      another.push(s);
    }
    _Stack<String> ret = new _Stack<>();
    for (String s : another) {
      ret.push(s);
    }
    return ret;
  }

  public static void main(String[] args) {
    _Stack<String> stack = new _Stack<>();
    String[] inputs = "it is the best of times".split("\\s+");
    for (String s : inputs) {
      stack.push(s);
    }
    PrintUtil.show(stack);
    _Stack<String> cps = copyStack(stack);
    assert stack != cps; // address is not equal
    PrintUtil.show(cps);

    // just iterate use one stack
//    times of best the is it
//    it is the best of times // the order is wrong
//    times of best the is it
//    times of best the is it
  }
}
