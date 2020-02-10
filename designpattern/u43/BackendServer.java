package designpattern.u43;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by HuGuodong on 2/10/20.
 */

public class BackendServer {

  private long serverNo;
  private String serverAddress;

  private static final int SERVER_COUNT = 3;
  private static final Map<Long, BackendServer> serverInstances = new HashMap<>();

  static {
    serverInstances.put(1L, new BackendServer(1L, "192.134.22.138:8080"));
    serverInstances.put(2L, new BackendServer(2L, "192.134.22.139:8080"));
    serverInstances.put(3L, new BackendServer(3L, "192.134.22.140:8080"));
  }

  private BackendServer(long serverNo, String serverAddress) {
    this.serverNo = serverNo;
    this.serverAddress = serverAddress;
  }

  public static BackendServer getInstance(long serverNo) {
    return serverInstances.get(serverNo);
  }

  public BackendServer getRandomInstance() {
    Random r = new Random();
    int no = r.nextInt(SERVER_COUNT) + 1;
    return serverInstances.get(no);
  }

  public static void main(String[] args) {
    BackendServer bs = BackendServer.getInstance(1);
    System.out.println(bs);

  }
}