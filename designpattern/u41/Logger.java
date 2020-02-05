package designpattern.u41;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by HuGuodong on 2/5/20.
 */

public class Logger implements AutoCloseable {

  private static FileWriter writer;

  public Logger() {
    File file = new File("log.txt");
    try {
      writer = new FileWriter(file, true); //true表示追加写入
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void log(String message) {
    try {
      writer.append(message);
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  @Override
  public void close() throws Exception {
    writer.flush();
    writer.close();
  }
}