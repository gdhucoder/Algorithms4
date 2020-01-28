![2020-01-28_000.jpg](https://gitee.com/gdhu/testtingop/raw/master/2020-01-28_000.jpg)

Depth First Search Trace: 

input: tinyCG.txt

```shell
dfs(0)
 dfs(2)
 |  check(0)
  dfs(1)
  |  check(0)
  |  check(2)
  1 done
  dfs(3)
   dfs(5)
   |  check(3)
   |  check(0)
   5 done
   dfs(4)
   |  check(3)
   |  check(2)
   4 done
  |  check(2)
  3 done
 |  check(4)
 2 done
|  check(1)
|  check(5)
0 done
0 1 2 3 4 5 
connected
```

