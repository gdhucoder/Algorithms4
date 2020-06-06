//给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。 
//
// 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。 
//
// 
//
// 示例 1： 
//
// 输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft
//"],["google","facebook"],["google"],["amazon"]]
//输出：[0,1,4] 
//解释：
//favoriteCompanies[2]=["google","facebook"] 是 favoriteCompanies[0]=["leetcode",
//"google","facebook"] 的子集。
//favoriteCompanies[3]=["google"] 是 favoriteCompanies[0]=["leetcode","google","f
//acebook"] 和 favoriteCompanies[1]=["google","microsoft"] 的子集。
//其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。
// 
//
// 示例 2： 
//
// 输入：favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"
//],["facebook","google"]]
//输出：[0,1] 
//解释：favoriteCompanies[2]=["facebook","google"] 是 favoriteCompanies[0]=["leetcod
//e","google","facebook"] 的子集，因此，答案为 [0,1] 。
// 
//
// 示例 3： 
//
// 输入：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
//输出：[0,1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= favoriteCompanies.length <= 100 
// 1 <= favoriteCompanies[i].length <= 500 
// 1 <= favoriteCompanies[i][j].length <= 20 
// favoriteCompanies[i] 中的所有字符串 各不相同 。 
// 用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompan
//ies[j] 仍然成立。 
// 所有字符串仅包含小写英文字母。 
// 
// Related Topics 排序 字符串


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _1452_PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {

  public static void main(String[] args) {
    Solution solution = new _1452_PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
      int n = favoriteCompanies.size();
      List<String>[] cast = favoriteCompanies.toArray(new List[0]);
      for (int i = 0; i < cast.length; i++) {
        cast[i] = cast[i].stream().map(x -> x.intern()).collect(Collectors.toList());
        cast[i].sort((a, b) -> a.compareTo(b));
      }
      List<Integer> ans = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        boolean valid = true;
        for (int j = 0; j < n && valid; j++) {
          if (i == j) {
            continue;
          }
          if (subset(cast[i], cast[j])) {
            valid = false;
          }
        }
        if (valid) {
          ans.add(i);
        }
      }
      return ans;
    }

    public boolean subset(List<String> a, List<String> b) {
      if (b.size() < a.size()) {
        return false;
      }
      int i = a.size() - 1;
      int j = b.size() - 1;
      while (i >= 0 && j >= 0) {
        if (b.get(j) == a.get(i)) {
          i--;
          j--;
          continue;
        }
        j--;
      }
      return i < 0;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}