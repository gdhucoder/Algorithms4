# 2020-02-17 HashMap, HashSet

[LeetCode.242](https://leetcode-cn.com/problems/valid-anagram/)

{% tabs %}
{% tab title="solution1" %}
```java
// use array then sort, compare
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
}
```
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}



