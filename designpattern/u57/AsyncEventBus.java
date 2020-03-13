package designpattern.u57;

import java.util.concurrent.Executor;

/**
 * Created by HuGuodong on 3/13/20.
 */

public class AsyncEventBus extends EventBus {

  public AsyncEventBus(Executor executor) {
    super(executor);
  }
}
