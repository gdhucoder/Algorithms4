package ALeetCode;

/**
 * Created by HuGuodong on 2019/11/4.
 */
public class P0393_2 {

  public boolean isSubsequence(String s, String t) {
    char[] chars = s.toCharArray();
    int index = -1;
    for (char temp : chars) {
      index = t.indexOf(temp, index + 1);
      if (index == -1) {
        return false;
      }
    }
    return true;
  }


}
