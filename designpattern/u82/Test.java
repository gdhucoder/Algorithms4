package designpattern.u82;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by HuGuodong on 5/11/20.
 */
public class Test {

  public static void main(String[] args) {
    List<Student> ori = new ArrayList<>();
    ori.add(new Student("xiaoqiang", 10));

    Student mutable = new Student("wangz", 8);
    ori.add(mutable);

    ori.add(new Student("lameda", 12));
    List<Student> jdkCopy = Collections.unmodifiableList(ori);

    // 复制了一份，list中的内容还是浅复制
    List<Student> guavaCopy = ImmutableList.copyOf(ori);

    ori.add(new Student("wawa", 20));

    System.out.println(jdkCopy);
    System.out.println(guavaCopy);

    mutable.name = "mutable";
    System.out.println(guavaCopy);
    //    [Student{age=10, name='xiaoqiang'}, Student{age=8, name='mutable'}, Student{age=12, name='lameda'}]

  }
}

class Student {

  int age;
  String name;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" + "age=" + age + ", name='" + name + '\'' + '}';
  }
}
