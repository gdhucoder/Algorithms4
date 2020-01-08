package designpattern.u14.storage;

/**
 * Created by HuGuodong on 12/4/19.
 */
public class MySqlCredentialStorage implements CredentialStorage {

  @Override
  public String getPasswordByAppID(String appId) {
    return "123";
  }
}
