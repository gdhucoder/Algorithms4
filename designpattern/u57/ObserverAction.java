package designpattern.u57;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by HuGuodong on 3/13/20.
 */

public class ObserverAction {

  private Object target;
  private Method method;

  public ObserverAction(Object target, Method method) {
    this.target = target;
    this.method = method;
    this.method.setAccessible(true);
  }

  public void execute(Object event) { // event是method方法的参数
    try {
      method.invoke(target, event);
    } catch (InvocationTargetException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
