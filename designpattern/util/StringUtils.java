package designpattern.util;

/**
 * Created by HuGuodong on 1/31/20.
 */
public class StringUtils {

  private StringUtils() {}

  public static boolean isBlank(String str) {
    return str == null || str.length() == 0;
  }
}
