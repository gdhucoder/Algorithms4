package edu.princeton.cs.myalg.u1;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;

/**
 * Created by HuGuodong on 2018/4/19.
 */

public class QuickUN extends QuickUF{

    public QuickUN(int N){
        super(N);
    }

    @Override
    public int find(int p){
        while (p!=id[p]){
            p = id[p];
        }

        return p;
    }

    @Override
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot){
            return;
        }
//        parent[pRoot] = qRoot; // attention: parent[] -> qRoot index.
        id[qRoot] = pRoot; // attention: parent[] -> qRoot index.
        count --;
    }

    public static void main(String[] args) throws Exception{
//        FileInputStream fis = new FileInputStream("C:\\Users\\guodonghu\\Dropbox\\Alg4\\test_data\\largeUF.txt");
        FileInputStream fis = new FileInputStream("E:\\GDUT\\Dropbox\\Alg4\\test_data\\tinyUF.txt");
        System.setIn(fis);
        int n = StdIn.readInt();
        QuickUF uf = new QuickUN(n);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)) continue;;
            uf.union(p,q);
            StdOut.println(p +" "+q);
        }
        StdOut.println(uf.count() + " components");
    }

}
