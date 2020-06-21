package ALeetCode.comp.p194;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public String[] getFolderNames(String[] names) {
      Map<String, Integer> map = new LinkedHashMap<>();
      List<String> res = new ArrayList<>();
      for (String name : names) {
        map.put(name, map.getOrDefault(name, 0) + 1);
        if (map.get(name) >= 1) {
          String temp = String.format(name + "(" + "%d" + ")", map.get(name));
          if (name.contains("(")) {
            map.put(name.substring(0, name.indexOf("(")),
                map.getOrDefault(name.substring(0, name.indexOf("(")), 0) + 1);
          }
          map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
      }
      return map.keySet().toArray(new String[0]);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String[] arr = {"gta", "gta(1)", "gta", "avalon"};
    PrintUtil.show(s.getFolderNames(arr));
    arr = new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
    PrintUtil.show(s.getFolderNames(arr));
    arr = new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"};
    PrintUtil.show(s.getFolderNames(arr));
    arr = new String[]{"pes", "fifa", "gta", "pes(2019)"};
    PrintUtil.show(s.getFolderNames(arr));
    arr = new String[]{"kingston(0)", "kingston", "kingston"};
    PrintUtil.show(s.getFolderNames(arr));
  }
}
