# 144. Binary Tree Preorder Traversal

## Problem

{% tabs %}
{% tab title="en" %}
```text
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
```
{% endtab %}

{% tab title="cn" %}
```text
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
```
{% endtab %}
{% endtabs %}

## Solution

{% tabs %}
{% tab title="1" %}
```java
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        if (node != null) {
            result.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
    }
    return result;
}
```
{% endtab %}

{% tab title="2" %}
```java
public List<Integer> preorderTraversal(TreeNode root) {
	List<Integer> result = new LinkedList<>();
	Deque<TreeNode> stack = new LinkedList<>();
	TreeNode node = root;
	while (node != null || !stack.isEmpty()) {
		if (node != null) {
			result.add(node.val);
			stack.push(node.right);
			node = node.left;
		} else {
			node = stack.pop();
		}
	}
	return result;
}
```
{% endtab %}

{% tab title="3" %}
```java
// Note that in this solution only right children are stored to stack.
public List<Integer> preorderTraversal(TreeNode node) {
	List<Integer> list = new LinkedList<Integer>();
	Stack<TreeNode> rights = new Stack<TreeNode>();
	while(node != null) {
		list.add(node.val);
		if (node.right != null) {
			rights.push(node.right);
		}
		node = node.left;
		if (node == null && !rights.isEmpty()) {
			node = rights.pop();
		}
	}
    return list;
}
```
{% endtab %}
{% endtabs %}

Date: 2020-02-19

