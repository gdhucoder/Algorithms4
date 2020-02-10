package designpattern.u43;

/**
 * Created by HuGuodong on 2/10/20.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import org.junit.Test;

public class MyClassLoader extends ClassLoader {

  /**
   * 重写父类方法，返回一个Class对象 ClassLoader中对于这个方法的注释是: This method should be overridden by class loader
   * implementations
   */
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    Class clazz = null;
    String classFilename = name + ".class";
    File classFile = new File(classFilename);
    if (classFile.exists()) {
      try (FileChannel fileChannel = new FileInputStream(classFile)
          .getChannel();) {
        MappedByteBuffer mappedByteBuffer = fileChannel
            .map(MapMode.READ_ONLY, 0, fileChannel.size());
        byte[] b = mappedByteBuffer.array();
        clazz = defineClass(name, b, 0, b.length);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (clazz == null) {
      throw new ClassNotFoundException(name);
    }
    return clazz;
  }


  @Test
  public void testLoad1() throws Exception {
    MyClassLoader2 myClassLoader2 = new MyClassLoader2();
    Class clazz2 = myClassLoader2.loadClass("designpattern.u43.Singleton");
    Method getInstance2 = clazz2.getMethod("getInstance");
    Singleton instance2 = (Singleton) getInstance2.invoke(null, null);
    System.out.println(instance2);
    testLoad2();
  }

  @Test
  public void testLoad2() throws Exception {
    MyClassLoader myClassLoader = new MyClassLoader();
    Class clazz = myClassLoader.loadClass("designpattern.u43.Singleton");
    Method getInstance = clazz.getMethod("getInstance");
    Singleton instance = (Singleton) getInstance.invoke(null, null);
    System.out.println(instance);
  }


  public static void main(String[] args) throws Exception {
    MyClassLoader myClassLoader = new MyClassLoader();
    Class clazz = myClassLoader.loadClass("designpattern.u43.Singleton");
    Method getInstance = clazz.getMethod("getInstance");
    Singleton instance = (Singleton) getInstance.invoke(null, null);
    System.out.println(instance);


  }
}