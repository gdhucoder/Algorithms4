package ALeetCode;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * unsolved yet Created by HuGuodong on 2019/11/11.
 */
public class p0008 {

  public int myAtoi(String str) {
    int idx = str.indexOf("\\d");
    str = str.stripLeading();
    String pattern = "^([-\\|+]?\\d+)";
    Pattern r = Pattern.compile(pattern);

    // 现在创建 matcher 对象

    Matcher m = r.matcher(str);

    System.out.println(m.groupCount());
    while (m.find()) {
      System.out.println(m.group());
    }
    return 0;
  }


  public static void main(String[] args) {
    p0008 p = new p0008();
    int ret = p.myAtoi("00000000200000000000000000000  666");

  }
}
