
data structures for shortest path

- parent-edge `edgeTo[v]`
- distance to source `distTo[v]`, represent the length of sp from `s` to `v`

![2020-05-12_000.jpg](https://gitee.com/gdhu/testtingop/raw/master/2020-05-12_000.jpg)

edge relaxation

![2020-05-12_001.jpg](https://gitee.com/gdhu/testtingop/raw/master/2020-05-12_001.jpg)

if the length to w is larger than the sum of length to `v` plus weight of `v` to `w`,
then `relax`: change `distTo[w] = distTo[v] + e.weight()` and `edgeTo[w] = e`.

![2020-05-12_003.jpg](https://gitee.com/gdhu/testtingop/raw/master/2020-05-12_003.jpg)

![2020-05-12_004.jpg](https://gitee.com/gdhu/testtingop/raw/master/2020-05-12_004.jpg)

![2020-05-12_005.jpg](https://gitee.com/gdhu/testtingop/raw/master/2020-05-12_005.jpg)

![2020-05-12_006.jpg](https://gitee.com/gdhu/testtingop/raw/master/2020-05-12_006.jpg)



