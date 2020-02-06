
## 0072 Edit Distance (hard)

### 问题

![problem](https://gitee.com/gdhu/testtingop/raw/master/2020-02-06_003.jpg)

### 笔记

![note](https://gitee.com/gdhu/testtingop/raw/master/2020-02-06_002.jpg)

### 代码

```java
    public int minDistance(String word1, String word2) {
      char[] a = word1.toCharArray();
      char[] b = word2.toCharArray();
      int m = a.length+1 , n = b.length+1;
      int[][] dp = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == 0) {
            dp[i][j] = j;
            continue;
          }
          if (j == 0) {
            dp[i][j] = i;
            continue;
          }
          dp[i][j] = Math.min(dp[i - 1][j - 1] + (a[i - 1] == b[j - 1] ? 0 : 1),
              Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
        }
      }
      return dp[m - 1][n - 1];
    }
```