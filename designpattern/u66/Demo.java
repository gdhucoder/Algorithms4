package designpattern.u66;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by HuGuodong on 4/6/20.
 */

public class Demo {

  public static void main(String[] args) {
    LinkedList<String> names = new LinkedList<>();
    names.add("a");
    names.add("b");
    names.add("c");
    names.add("d");

    ListIterator<String> iterator1 = names.listIterator();
    //    Iterator<String> iterator2 = names.iterator();

    while (iterator1.hasNext()) {
      System.out.println(iterator1.next());
      iterator1.add("e");
      iterator1.add("f");
      //      iterator1.remove();
    }

    System.out.println(names.size());
    //    System.out.println(iterator1.);
    //    iterator1.next();
    //    iterator1.remove(); // mod = 5
    //    iterator2.next(); // 运行结果？
  }
}
