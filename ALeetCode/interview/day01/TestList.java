package ALeetCode.interview.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 2020/6/5.
 */
public class TestList {

  public static void main(String[] args) {
    List<String> l = List.of("aa", "bbb");
    System.out.println(l);
    l.add("cc"); //ImmutableCollections$AbstractImmutableCollection
    System.out.println(l);
    List<Integer> ll = new ArrayList<>();
  }
}
