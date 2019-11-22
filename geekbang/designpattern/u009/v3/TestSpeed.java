package geekbang.designpattern.u009.v3;

import Ch_1_4._Stopwatch;

/**
 * Created by HuGuodong on 11/22/19.
 */
public class TestSpeed {


  public static void main(String[] args) throws Exception {
    int NUM = 1000000;
    _Stopwatch time = new _Stopwatch();
    for (int i = 0; i < NUM; i++) {
      // new Instance
      ImageStore store = new ImageStore();
    }
    System.out.println(time.elapsedTime() + " s");
    for (int i = 0; i < NUM; i++) {
      // reflection
      ImageStore store = (ImageStore) Class.forName("geekbang.designpattern.u009.v3.ImageStore")
          .newInstance();
    }
//    0.005 s
//    0.841 s
    System.out.println(time.elapsedTime() + " s");

  }
}
