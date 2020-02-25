package designpattern.u48;

/**
 * Created by HuGuodong on 2/25/20.
 */
public interface IUserController {

  void login();
}

class UserController implements IUserController {

  @Override
  public void login() {
    System.out.println("UserController login...");
  }
}