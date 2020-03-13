package designpattern.u57;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 3/13/20.
 */
public class TestClient {

  public static void main(String[] args) {
    UserController controller = new UserController();
    List<Object> observers = new ArrayList<>();
    observers.add(new RegPromotionObserver());
    controller.setRegObservers(observers);
    controller.register("2123", "xxx");
    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
