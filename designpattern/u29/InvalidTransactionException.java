package designpattern.u29;

/**
 * Created by HuGuodong on 1/8/20.
 */
public class InvalidTransactionException extends Exception {

  public InvalidTransactionException(String message) {
    super(message);
    System.out.println(message);
  }

}
