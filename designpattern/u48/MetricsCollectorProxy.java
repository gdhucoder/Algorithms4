package designpattern.u48;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by HuGuodong on 2/25/20.
 */
public class MetricsCollectorProxy {

  public Object createProxy(Object proxiedObject) {
    Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
    DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
    return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
  }

  private class DynamicProxyHandler implements InvocationHandler {

    private Object proxiedObject;

    public DynamicProxyHandler(Object proxiedObject) {
      this.proxiedObject = proxiedObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      System.out.println("in proxy");
      Object result = method.invoke(proxiedObject, args);
      String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
      System.out.println("apiName: " + apiName);
      return result;
    }
  }

  public static void main(String[] args) {
    MetricsCollectorProxy proxy = new MetricsCollectorProxy();
    IUserController userController = (IUserController) proxy.createProxy(new UserController());
    userController.login();
  }
}

