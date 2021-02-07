package ALeetCode.comp.p227;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public String largestMerge(String word1, String word2) {
      char[] chs1 = word1.toCharArray();
      char[] chs2 = word2.toCharArray();
      StringBuffer sb = new StringBuffer();
      int idx1 = 0, idx2 = 0;
      while (idx1 < chs1.length && idx2 < chs2.length) {
        int comp = compare(chs1, idx1, chs2, idx2);
        if (comp >= 0) {
          sb.append(chs1[idx1++]);
        }
        else if (comp < 0) {
          sb.append(chs2[idx2++]);
        }
      }
      System.out.println(idx1 + ":" + word1.length());
      System.out.println(idx2 + ":" + word2.length());
      System.out.println(sb.toString());
      System.out.println(word2.substring(idx2));
      if (idx1 < chs1.length) {
        sb.append(word1, idx1, word1.length());
      }

      if (idx2 < chs2.length) {
        sb.append(word2, idx2, word2.length());
      }
      return sb.toString();
    }

    private static int compare(char[] chs1, int idx1, char[] chs2, int idx2) {
      while (idx1 < chs1.length && idx2 < chs2.length) {
        if (chs1[idx1] > chs2[idx2]) {
          return 1;
        }
        else if (chs1[idx1] < chs2[idx2]) {
          return -1;
        }
        else {
          idx1++;
          idx2++;
        }
      }
      if (idx1 < chs1.length) {
        return 1;
      }
      if (idx2 < chs2.length) {
        return -1;
      }
      return 0;
    }
  }

  private static int comp(String s1, String s2) {
    char[] chs1 = s1.toCharArray();
    char[] chs2 = s2.toCharArray();
    for (int i = 0; i < chs1.length; i++) {
      if (chs1[i] != chs2[i]) {
        System.out.println("not equal  " + i + "");
        System.out.println(s1.substring(i, s1.length()));
        System.out.println(s2.substring(i, s2.length()));
        break;
      }
    }
    // guggggggguuggguugggggg
    //
    return 0;

  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
    String s1 = "guguuuuuuuuuuuuuuguguuuuguug";
    String s2 = "gguggggggguuggguugggggg";
    String res = s.largestMerge(s1, s2);
    String ans = "guguuuuuuuuuuuuuuguguuuuguugguggggggguuggguuggggggg";
    comp(res, ans);
    System.out.println(res);
  }
}
