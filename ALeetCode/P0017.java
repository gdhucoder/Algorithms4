package ALeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HuGuodong on 2019/11/9.
 */
public class P0017 {

  private Map<String, char[]> numToLetters = new HashMap<>();
  private List<String> list = new ArrayList<>();

  private void init() {
    numToLetters.put("2", "abc".toCharArray());
    numToLetters.put("3", "def".toCharArray());
    numToLetters.put("4", "ghi".toCharArray());
    numToLetters.put("5", "jkl".toCharArray());
    numToLetters.put("6", "mno".toCharArray());
    numToLetters.put("7", "pqrs".toCharArray());
    numToLetters.put("8", "tuv".toCharArray());
    numToLetters.put("9", "wxyz".toCharArray());
  }

  public List<String> letterCombinations(String digits) {
    init();
    char[] characters = digits.toCharArray();
    genLetter(characters, 0, "");
    return list;
  }

  public void genLetter(char[] digits, int curLen, String s) {
    if (curLen == digits.length) {
      list.add(s);
      return;
    }
    char[] letters = numToLetters.get("" + digits[curLen]);
    for (int j = 0; j < letters.length; j++) {
      genLetter(digits, curLen + 1, s + letters[j]);
    }
  }


  public static void main(String[] args) {
    // 23
    // 2->abc 3 def, ad,ae,af
    P0017 p = new P0017();
    p.letterCombinations("234");
    System.out.println(p.list);
  }

}
