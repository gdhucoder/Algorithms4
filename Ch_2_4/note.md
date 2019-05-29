PRIORITY QUEUES 优先队列

Heap: key in each node is larger than or equal to the keys in that's node's two children (if any)

Representation: linked list, array

![2019-05-19-002](https://gitee.com/gdhu/prvpic/raw/master/2019-05-19-002.jpg)


![2019-05-19-003](https://gitee.com/gdhu/prvpic/raw/master/2019-05-19-003.jpg)

Binary Heap: a binary heap is a collection of keys arranged in a complete heap-ordered binary
tree, represented in level order in an array (not using the first entry)


Operation: insert and remove the maximum

![operation](https://gitee.com/gdhu/prvpic/raw/master/2019-05-19-004.jpg)

多叉堆：multiway heaps 树的高度和子节点找到最大值的折中。

1-based indexing: 数组以1开头访问

0-based indexing：数组以0开头访问

