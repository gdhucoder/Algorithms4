package tools;

/**
 * Created by HuGuodong on 2019/7/16.
 */

public class Constant {

  public static String getCurDir(String path) {
    return System.getProperty("user.dir") + "\\src\\main\\java\\" + path;
  }
}
