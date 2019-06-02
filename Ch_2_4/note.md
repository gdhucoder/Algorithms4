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

使用索引优先队列可以解决多路归并问题。

it merges together sorted input streams into one sorted output stream.

`

E:\gitspace\x1c\Alg4\algs4\target\classes>more m1.txt
A B C F G I I Z

E:\gitspace\x1c\Alg4\algs4\target\classes>more m2.txt
B D H P Q Q

E:\gitspace\x1c\Alg4\algs4\target\classes>more m3.txt
A B E F J N


//    E:\gitspace\x1c\Alg4\algs4>cd .\target\classes
//
//    E:\gitspace\x1c\Alg4\algs4\target\classes>java Ch_2_4._Multiway m1.txt m2.txt m3.txt

A
A
B
B
B
C
D
E
F
F
G
H
I
I
J
N
P
Q
Q
Z

`


