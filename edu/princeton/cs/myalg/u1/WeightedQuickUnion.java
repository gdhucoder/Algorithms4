package edu.princeton.cs.myalg.u1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.FileInputStream;

public class WeightedQuickUnion {
    public int parent[]; // parent[i] = parent of i
    public int size[]; // size[i] = number of sites in subtree
    public int count; // number of components

    public WeightedQuickUnion(int N){
        parent = new int[N];
        size = new int[N];
        count = N;
        for(int i=0; i<N; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * Returns the number of components
     * @return
     */
    public int count(){
        return count;
    }

    /**
     * find root of p
     * @param p
     * @return
     */
    public int find(int p){
        while (p!= parent[p]){
            p = parent[p];
        }
        return p;
    }

    /**
     * Merges the component containing size{@code p} with the
     * component containing site {@code q}.
     * @param p the integer representing one site
     * @param q the integer representing the other site
     */
    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);

        if(size[p] < size[q]){
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }else{
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    /**
     * Read in a sequence of pairs of integers (between 0 and n-1) from standard input,
     * where each integer represents some object;
     * if the sites are different components, merge the two components
     * and print the pair to standard output.
     * @param args the command-line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
//        FileInputStream fis = new FileInputStream("C:\\Users\\guodonghu\\Dropbox\\Alg4\\test_data\\largeUF.txt");
        FileInputStream fis = new FileInputStream("E:\\GDUT\\Dropbox\\Alg4\\test_data\\mediumUF.txt");
        System.setIn(fis);
        int n = StdIn.readInt();
        Stopwatch timer1 = new Stopwatch();
        WeightedQuickUnion uf = new WeightedQuickUnion(n);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)) continue;;
            uf.union(p,q);
            StdOut.println(p +" "+q);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%.2f seconds\n", time1);
        StdOut.println(uf.count() + " components");
    }
}
