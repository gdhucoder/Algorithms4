package other.callback;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/5.
 */

/**
 * 关于回调：
 * 生活中的场景，例如：
 * 1） 同步回调
 * 小熊熊向baby借一本书，baby说你等一下，我去拿。然后熊熊一直等着baby回家拿书给他。
 * 2）异步回调
 * 小熊向baby借一本书，然后baby说，我知道了，我回家去拿，拿到了再给你。熊熊不必一直等着（熊熊不知道baby什么时候把书拿给他）。
 * 借书可以是一个接口，里面传入书的名字。
 */
public class People {

  Printer printer = new Printer();

  /**
   * 同步回调
   * @param callback
   * @param text
   */
  public void goToPrintSyn(PrinterCallback callback, String[] text){
    text[1] = "goToPrintSyn";
    printer.print(callback, text[0]);
  }


  /**
   * 异步回调
   * @param callback
   * @param text
   */
  public void goToPrintAsync(PrinterCallback callback, String[] text){

    new Thread(new Runnable() {
      @Override
      public void run() {
        text[1] = "goToPrintAsync";
        printer.print(callback, text[0]);
      }
    }).start();

  }


  public static void main(String[] args) {
    People people = new People();
    String[] text = new String[2];
    text[0] = "打印一份简历";
    text[1] = "改变信息";
    PrinterCallback callback = new PrinterCallback() {
      @Override
      public void printfinished(String msg) {
        StdOut.println("请告诉我打印信息是："+ msg);
      }
    };
    System.out.println("需要打印的内容是 ---> " + "打印一份简历");
    people.goToPrintAsync(callback, text);
    System.out.println("我在等待 打印机 给我反馈");
    StdOut.println(text[1]);
  }

}
