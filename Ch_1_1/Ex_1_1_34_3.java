package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/6/11.
 */

public class Ex_1_1_34_3 {

  /**
   * 关于基本类型的转型计算
   * @param args
   */
  public static void main(String[] args) {
    double avg = (double) (2 / 3); // 整型2/3 结果是0，所以会输出0.0
    StdOut.println(avg);
    avg = (double) 2 / 3;// 将2转型是double，会输出0.666666
    StdOut.println(avg);
//    0.0
//    0.6666666666666666

  }
}
