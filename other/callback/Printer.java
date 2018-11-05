package other.callback;

/**
 * Created by HuGuodong on 2018/11/5.
 */

public class Printer {

  public void print(PrinterCallback callback, String text){

    System.out.println("正在打印 . . . ");
    try {
      Thread.currentThread();
      Thread.sleep(3000);// 毫秒
    } catch (Exception e) {

    }
    callback.printfinished("打印完成");

  }

}
