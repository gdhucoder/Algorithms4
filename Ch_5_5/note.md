```java

目录：

E:\gitspace\x1c\Alg4\algs4\target\classes>

文件的内容是：

ABRACADABRA!


Java 命令

java Ch_5_5._BinaryDump 16 < abra.txt

java Ch_5_5._PictureDump 16 6 < abra.txt

java Ch_5_5._PictureDump 100 100 < abra.txt

java Ch_5_5._RandomBits | java Ch_5_5._PictureDump 2000 500

```

E:\gitspace\x1c\Alg4\algs4\target\classes


java Ch_5_5._BinaryDump 64 < genomeTiny.txt

```code

java Ch_5_5._BinaryDump 64 < genomeTiny.txt

0100000101010100010000010100011101000001010101000100011101000011
0100000101010100010000010100011101000011010001110100001101000001
0101010001000001010001110100001101010100010000010100011101000001
0101010001000111010101000100011101000011010101000100000101000111
01000011
264 bits.

java Ch_5_5._Genome - < genomeTiny.txt
输出了乱码：
   !窷Lw搥

java Ch_5_5._Genome - < genomeTiny.txt | java Ch_5_5._BinaryDump 64

0000000000000000000000000010000100010011000111100001001110111000
0100111001001100011101111001001110000000
104 bits.

java Ch_5_5._Genome - < genomeTiny.txt | java Ch_5_5._HexDump 8

00 00 00 21 13 1e 13 b8
4e 4c 77 93 80
104 bits

输出到
java Ch_5_5._Genome - < genomeTiny.txt > genomeTiny.2bit

输出
java Ch_5_5._Genome + < genomeTiny.2bit

java Ch_5_5._Genome - < genomeTiny.txt | java Ch_5_5._Genome +

ATAGATGCATAGCGCATAGCTAGATGTGCTAGC

java Ch_5_5._PictureDump 512 100 < genomeVirus.txt

java Ch_5_5._Genome - < genomeVirus.txt | java Ch_5_5._PictureDump 512 25

java Ch_5_5._BinaryDump 32 < q32x48.bin

java Ch_5_5._BinaryDump 40 < 4runs.bin

java Ch_5_5._RunLength - < abra.txt | java Ch_5_5._HexDump 24

java Ch_5_5._BinaryDump 40 < abra.txt

java Ch_5_5._RunLength - < q32x48.bin  | java Ch_5_5._HexDump 24

java Ch_5_5._RunLength - < 4runs.bin  | java Ch_5_5._HexDump 24
```
