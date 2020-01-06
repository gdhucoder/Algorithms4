package geekbang.ALGO.interview.u39;

/**
 * Created by HuGuodong on 1/6/20.
 */
public class Test {

  public static void main(String[] args) {
    int x = 6;
    System.out.println(x & (x - 1)); // 清除低位的1，例如110 -> x&(x-1) ->100 ->4
    // x & -x,得到最低位的1,110 -> 最低位的1 为10 输出结果2
    System.out.println(x & -x);
  }
}
