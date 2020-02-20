# 84. Largest Rectangle in Histogram

[LeetCode 84](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

{% tabs %}
{% tab title="First Tab" %}
```text
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:

Input: [2,1,5,6,2,3]
Output: 10
```
{% endtab %}
{% endtabs %}

{% tabs %}
{% tab title="brute force" %}
```java
class Solution {
    public int largestRectangleArea(int[] a) {
       int maxarea = 0;
       int n = a.length;
       for (int i=0; i<n; i++) {
         for (int j=i; j<n; j++) {
            int minHeight = Integer.MAX_VALUE;
            for (int k=i; k<=j; k++) {
              minHeight = Math.min(a[k], minHeight);
            }
            int area = (j-i+1) * minHeight;
            maxarea = Math.max(area, maxarea);
         }
       } 
       return maxarea;
    }
}
```
{% endtab %}

{% tab title="improve brute force" %}
```java
class Solution {
    public int largestRectangleArea(int[] a) {
      int n = a.length;
      int maxarea = 0;
      for (int i=0; i<n; i++) {
        int minHeight = Integer.MAX_VALUE;
        for (int j=i; j<n; j++) {
          minHeight = Math.min(a[j], minHeight);
          int area = (j-i+1) * minHeight;
          maxarea = Math.max(area, maxarea);
        }
      }
      return maxarea;
    }
}
```
{% endtab %}

{% tab title="clever solution" %}
```java
class Solution {
    public int largestRectangleArea(int[] height) {
    if (height == null || height.length == 0) {
        return 0;
    }
    int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
    int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
    lessFromRight[height.length - 1] = height.length;
    lessFromLeft[0] = -1;

    for (int i = 1; i < height.length; i++) {
        int p = i - 1;
        while (p >= 0 && height[p] >= height[i]) {
            p = lessFromLeft[p];
        }
        lessFromLeft[i] = p;
    }

    for (int i = height.length - 2; i >= 0; i--) {
        int p = i + 1;
        while (p < height.length && height[p] >= height[i]) {
            p = lessFromRight[p];
        }
        lessFromRight[i] = p;
    }

    int maxArea = 0;
    for (int i = 0; i < height.length; i++) {
        maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
    }
    return maxArea;
  }
}
```
{% endtab %}

{% tab title="stack solution" %}
```
// TODO
```
{% endtab %}
{% endtabs %}

Reference : 

{% embed url="https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O\(n\)-Java-solution-explained-\(beats-96\)" %}

{% embed url="https://www.geeksforgeeks.org/largest-rectangle-under-histogram/" %}



