package designpattern.u34;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by HuGuodong on 1/20/20.
 */

public class IdGenerator {

  //  private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);
  public static final String BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  private static final char[] CHAR_SET = BASE62.toCharArray();

  public static String generate() {

    // get host name
    String hostName = null;
    try {
      hostName = InetAddress.getLocalHost().getHostName();
      String[] tokens = hostName.split("\\.");
      hostName = tokens[tokens.length - 1];
    } catch (UnknownHostException e) {
      hostName = "UNKNOWN";
    }

    // random chars
    char[] randomChars = new char[8];
    Random random = new Random();
    for (int i = 0; i < randomChars.length; i++) {
      int rndIdx = random.nextInt(CHAR_SET.length);
      randomChars[i] = CHAR_SET[rndIdx];
    }

    // generate id
    String id = String.format("%s-%d-%s", hostName,
        System.currentTimeMillis(), new String(randomChars));

    return id;
  }

  public static void main(String[] args) {
    char z = 'z';
    System.out.println((int) z);
    for (int i = 0; i < 10000; i++) {
      String id = generate();
      System.out.println(id);
    }

  }
}