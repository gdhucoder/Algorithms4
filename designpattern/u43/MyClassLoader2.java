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

public class MyClassLoader2 extends ClassLoader {

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

  public static void main(String[] args) throws Exception {
    MyClassLoader2 myClassLoader = new MyClassLoader2();
    Class clazz = myClassLoader.loadClass("designpattern.u43.Singleton");
    Method getInstance = clazz.getMethod("getInstance");
    Singleton instance = (Singleton) getInstance.invoke(null, null);
    System.out.println(instance);
  }
}