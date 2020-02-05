package designpattern.u41;

/**
 * Created by HuGuodong on 2/5/20.
 */
public class LoggerTest {

  public static void main(String[] args) {
    Logger logger1 = new Logger();
    Logger logger2 = new Logger();

    Runnable r1 = () -> {
      for (int i = 0; i < 100; i++) {
        String s = i + ": is a test " + System.currentTimeMillis() + "\n";
        logger1.log(s);
      }
    };

    Runnable r2 = () -> {
      for (int i = 100; i < 200; i++) {
        String s = i + ": is a test " + System.currentTimeMillis() + "\n";
        logger2.log(s);
      }
    };

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);
    t1.run();
    t2.run();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
