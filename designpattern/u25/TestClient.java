package designpattern.u25;

/**
 * Created by HuGuodong on 12/30/19.
 */
public class TestClient {

  public static void main(String[] args) {
    UserController controller = new UserController();
    int CALL_TIMES = 10;
    for (int i = 0; i < CALL_TIMES; i++) {
      controller.login();
      controller.register();
    }
  }
}
