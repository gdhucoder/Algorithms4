package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/8.
 */

public class Ex_1_3_09 {

  public static String convert(String exprs) {
    _Stack<String> expr = new _Stack<>();
    _Stack<String> ops = new _Stack<>();
    String[] in = exprs.split("\\s+");
    PrintUtil.show(in);
    for (int i = 0; i < in.length; i++) {
      if (in[i].equals("+")
          || in[i].equals("-")
          || in[i].equals("*")
          || in[i].equals("/")) {
        ops.push(in[i]);
      } else if (in[i].equals(")")) {
        String right = expr.pop();
        String left = expr.pop();
        String exp = "( " + left + " " + ops.pop() + " " + right + " )";
        expr.push(exp);
      } else {
        expr.push(in[i]);
      }
    }
    return expr.pop();
  }

  public static void main(String[] args) {
    String exprs = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
    StdOut.println(convert(exprs));
//    1	+	2	)	*	3	-	4	)	*	5	-	6	)	)	)
//    ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
  }
}
