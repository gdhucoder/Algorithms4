package edu.princeton.cs.myalg.u1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.FileInputStream;

public class QuickUF {
    public int[] id; // access to component parent
    public int count; // number of components

    public QuickUF(){}

    public QuickUF(int N){
        count = N;
        id = new int[N];
        for(int i=0; i<N; i++){
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public int find(int p){
        return id[p];
    }

    public void union(int p, int q){
        int pID = id[p];
        int qID = id[q];
        if(pID == qID){
            return ;
        }
        for(int i=0; i<id.length; i++){
            if(id[i] == pID){
                id[i] = qID;
            }
        }
        count--; // per union count = count - 1;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("E:\\GDUT\\Dropbox\\Alg4\\test_data\\mediumUF.txt");
        System.setIn(fis);
        int n = StdIn.readInt();

        Stopwatch timer1 = new Stopwatch();
        QuickUF uf = new QuickUF(n);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p +" "+q);
        }

        StdOut.println(uf.count() + " components");
        double time1 = timer1.elapsedTime();
        StdOut.printf("%.2f seconds\n", time1);
    }
}
