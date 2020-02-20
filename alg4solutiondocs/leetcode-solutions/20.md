# 20. Valid Parentheses

给定一个只包括 '\('，'\)'，'{'，'}'，'\['，'\]' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。

示例 1:

输入: "\(\)" 输出: true 

示例 2:

输入: "\(\)\[\]{}" 输出: true 

示例 3:

输入: "\(\]" 输出: false 

示例 4:

输入: "\(\[\)\]" 输出: false 

示例 5:

输入: "{\[\]}" 输出: true

{% tabs %}
{% tab title="Java" %}
```java
class Solution {
    public boolean isValid(String s) {
       if ((s.length() & 1) == 1 ) return false;
       char[] exp = s.toCharArray();
       char[] stack = new char[exp.length/2+1];
       int pos = 0;
       for (char c : exp) {
         if (c=='(') stack[pos++] = ')';
         else if (c=='{') stack[pos++] = '}';
         else if (c=='[') stack[pos++] = ']';
         else if (--pos<0 || stack[pos]!=c || pos>exp.length/2)
            return false;
       }
       return pos == 0;
    }
}
```
{% endtab %}

{% tab title="use map" %}
```java
this.mappings = new HashMap<Character, Character>();
this.mappings.put(')', '(');
this.mappings.put('}', '{');
this.mappings.put(']', '[');

```
{% endtab %}
{% endtabs %}



