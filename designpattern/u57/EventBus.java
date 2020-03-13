package designpattern.u57;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by HuGuodong on 3/13/20.
 */

public class EventBus {

  private Executor executor;
  private ObserverRegistry registry = new ObserverRegistry();

  public EventBus() {
    //    this(MoreExecutors.directExecutor());
  }

  protected EventBus(Executor executor) {
    this.executor = executor;
  }

  public void register(Object object) {
    System.out.println("event bus register");
    registry.register(object);
  }

  public void post(Object event) {
    List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
    for (ObserverAction observerAction : observerActions) {
      executor.execute(new Runnable() {
        @Override
        public void run() {
          System.out.println("post...");
          observerAction.execute(event);

        }
      });
    }
  }
}

