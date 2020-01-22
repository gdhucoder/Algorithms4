package designpattern.u35;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by HuGuodong on 1/22/20.
 */

public class RandomLogTraceGenerator implements LogTraceIDGenerator {

  public static final String BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  private static final char[] CHAR_SET = BASE62.toCharArray();

  @Override
  public String generate() {
    String lastField = getLastFieldOfHostName();
    char[] chars = genRandomChars(8);
    String result = formatID(lastField, chars);
    return result;
  }

  private char[] genRandomChars(int length) {
    char[] result = new char[length];
    Random random = new Random();
    for (int i = 0; i < length; i++) {
      result[i] = CHAR_SET[random.nextInt(CHAR_SET.length)];
    }
    return result;
  }

  private String getLastFieldOfHostName() {
    try {
      String hostName = InetAddress.getLocalHost().getHostName();
      String[] tokens = hostName.split("\\.");
      String result = tokens[tokens.length - 1];
      return result;
    } catch (UnknownHostException e) {
      System.out.println(e);
    }
    return "NULL";
  }

  private String formatID(String hostName, char[] randomChars) {
    String result = String.format("%s-%d-%s", hostName,
        System.currentTimeMillis(), new String(randomChars));
    return result;
  }
}
