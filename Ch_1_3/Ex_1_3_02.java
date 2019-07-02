package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Stack;

/**
 * Created by HuGuodong on 2019/7/2.
 */

public class Ex_1_3_02 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
//    while (!StdIn.isEmpty()){
//      String s = StdIn.readString();
//      if(s.equals("-")){
//        StdOut.println(stack.pop());
//      }else{
//        stack.push(s);
//      }
//    }
    String[] a = "it was - the best - of times - - - it was - the - -".split("\\s+");
    StdOut.println(a.length);
    for (String s : a) {
      if (s.equals("-")) {
        StdOut.println(stack.pop());
      } else {
        stack.push(s);
      }
    }
//    was
//    best
//    times
//    of
//    the
//    was
//    the
//    it
  }
}
