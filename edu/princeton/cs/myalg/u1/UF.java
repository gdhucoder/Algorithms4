package edu.princeton.cs.myalg.u1;

/**
 * Created by HuGuodong on 2018/4/17.
 */

public class UF {
    private int[] id;
    private int count; // number of components

    public UF(int N){
        count = N;
        id = new int[N];
        for(int i=0; i<N;i++){
            id[i] = i;
        }
    }
}
