---
title: "字符串匹配基础（上）"
date: 2019-02-21T22:20:32+08:00
draft: false
tags:
   - JAVA
categories:
  - 技术
  - 归档
---


# 字符串搜索算法

## BF算法(brute force)



两个术语：主串、模式串

比方说，我们在字符串A中查找B，那A就是主串，B就是模式串。我们把主串的长度记作N，模式串的长度记为M。因为在主串中查找模式串，所以N>M。

作为最简单，最暴力的字符串匹配算法，BF算法的思想，可以用一句话来概括，那就是：我们在主串中，检查其实位置分别是0,1,2, ... , n-m且长度为m的n-m+1个子串，看有没有跟模式串匹配的。

![2019-02-26-001](https://gitee.com/gdhu/prvpic/raw/master/2019-02-26-001.png)

算法实现：


第一种方法 i 指向匹配子串的起始位置。

```java
  public static int search(String txt, String pat) {
    int N = txt.length();
    int M = pat.length();
    for (int i = 0; i <= N - M; i++) {
      int j;
      for (j = 0; j < M; j++) {
        if (txt.charAt(i + j) != pat.charAt(j))
          break;
      }
      if (j == M)
        return i;
    }
    return N;
  }
```

第二种方法 i 指向匹配子串的末尾。

```java
  public static int search2(String txt, String pat) {
    int N = txt.length();
    int M = pat.length();
    // i points to end of substring
    int i, j;
    for (i = 0, j = 0; i < N && j < M; i++) {
      if (txt.charAt(i) == pat.charAt(j)) {
        j++; // match
      } else {
        i -= j; // miss match
        j = 0;
      }
    }

    if (j == M)
      return i - M; // found
    else
      return N; // not found
  }

```

尽管理论上最坏时间复杂度为O(n*m)，但在实际开发中，它却是一个很常用的字符串匹配算法。

为什么呢？

1、在实际的软件开发中，大部分情况下，模式串和主串的长度都不会太长。而且每次模式串与主串中的子串匹配的时候，当途中遇到不能匹配的字符的时候，就可以停止了，不需要把M个字符都对比一下。所以，尽管理论上最坏时间复杂度为O(N*M)，但是，统计意义上，大部分情况下，算法的平均时间复杂度为O(N)。

2、朴素字符串匹配算法思想简单，代码的实现也非常简单。简单意味着不容易出错，如果有bug也容易暴露和修复。在工程中，在性能要求满足的前提下，简单是首选。这也是我们常说的，[KISS原则](https://en.wikipedia.org/wiki/KISS_principle)。

所以，在实际软件开发中，绝大部分情况下，朴素的字符串匹配算法就够用了。

## RK算法

本质上和BF算法一样。但可以通过哈希函数计算模式串和主串中子串的哈希值。哈希值的计算和比较很高效。

具体的，每个子串的哈希值计算为常数时间。利用了子串间的哈希函数交集。

通过哈希函数的设计，可以避免碰撞。

使用除留余数法，选择一个大的质数，例如10的20次方大的。碰撞的概率为10^-20。是一个很低的概率。

算法时间复杂度为O(N)。




![2019-02-26-002](https://gitee.com/gdhu/prvpic/raw/master/2019-02-26-002.png)

![2019-02-26-003](https://gitee.com/gdhu/prvpic/raw/master/2019-02-26-003.png)


