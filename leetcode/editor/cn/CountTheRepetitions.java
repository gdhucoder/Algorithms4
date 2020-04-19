//由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。 
//
// 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得
//，但不能从 “acbbe” 获得。 
//
// 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S
//1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。 
//
// 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。 
//
// 
//
// 示例： 
//
// 输入：
//s1 ="acb",n1 = 4
//s2 ="ab",n2 = 2
//
//返回：
//2
// 
// Related Topics 动态规划


package leetcode.editor.cn;

public class CountTheRepetitions {

  /**
   * https://leetcode.com/problems/count-the-repetitions/discuss/95397/c-0ms-ostr1lengthstr2length
   * https://leetcode.com/problems/count-the-repetitions/discuss/95402/Very-clean-and-short-7ms-Java-solution-based-on-%4070664914-'s-idea
   *
   * @param args
   */
  public static void main(String[] args) {
    Solution solution = new CountTheRepetitions().new Solution();
    System.out.println(solution.getMaxRepetitions("abaacdbac", 100, "adcbd", 4));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  public class Solution {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
      int[] reps = new int[102];
      int[] rests = new int[102];
      int posRest = 0, repTime = 0;
      int i = 0, k = 0;
      if (n1 <= 0) return 0;
      while (k == i) {
        i++;
        for (int j = 0; j < s1.length(); j++) {
          if (s2.charAt(posRest) == s1.charAt(j)) {
            posRest++;
            if (posRest == s2.length()) {
              repTime++;
              posRest = 0;
            }
          }
        }
        if (i >= n1) return repTime / n2;
        for (k = 0; k < i; k++) {
          if (posRest == rests[k]) break;
        }
        reps[i] = repTime;
        rests[i] = posRest;
      }
      int interval = i - k;
      int repeatCount = (n1 - k) / interval;
      int repeatTimes = repeatCount * (reps[i] - reps[k]);
      int remainTimes = reps[(n1 - k) % interval + k];
      return (repeatTimes + remainTimes) / n2;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}