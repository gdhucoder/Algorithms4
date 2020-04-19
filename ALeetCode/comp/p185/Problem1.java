package ALeetCode.comp.p185;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public String reformat(String s) {
      char[] chs = s.toCharArray();
      char[] letters = new char[chs.length];
      char[] nums = new char[chs.length];
      int word_pos = 0, num_pos = 0;
      for (char c : chs) {
        if (c >= '0' && c <= '9') nums[num_pos++] = c;
        else letters[word_pos++] = c;
      }
      if (Math.abs(num_pos - word_pos) >= 2) return "";
      StringBuilder ans = new StringBuilder(chs.length);
      int i = 0;
      for (i = 0; i < Math.min(num_pos, word_pos); i++) {
        ans.append(letters[i]);
        ans.append(nums[i]);

      }
      if (word_pos > num_pos && i < word_pos) ans.append(letters[word_pos - 1]);
      if (num_pos > word_pos && i < num_pos) ans.insert(0, nums[num_pos - 1]);
      return ans.toString();
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
