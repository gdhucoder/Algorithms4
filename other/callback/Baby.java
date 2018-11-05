package other.callback;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/5.
 */

public class Baby {


  BookStore bookStore = new BookStore();

  final class BookStore {
    public String buyBook(Callback callback, String name){
      return  callback.doSomething("书的名字是：" + name);
    }
  }

  /**
   * 同步回调
   * @param callback
   * @param book
   * @return
   */
  public String helpBear(Callback callback, String book){
    return bookStore.buyBook(callback, book);
  }

  /**
   * 异步回调：不能返回可变对象
   * @param callback
   * @param book
   * @return
   */
  public String helpBearAsync(Callback callback, String book){

    String msg = null;

    return msg;
  }



  public static void main(String[] args) {

    Baby baby = new Baby();
    Callback callback = new Callback() {
      @Override
      public String doSomething(String msg) {
        return "doSomething " + msg;
      }
    };
    String msg = baby.helpBear(callback, "算法导论");
    StdOut.println(msg);

  }

}
