package Ch_1_4;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_4_12 {
    public static void print(int[]a ,int[] b){
        int i =0,j = 0;
        while (i<a.length && j<b.length){
            if(a[i]<b[j]){
                i++;
            }else if(a[i]>b[j]){
                j++;
            }else {
                StdOut.println(a[i]);
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[]a = {1,2,2,2,3,4,4,4,4};
        int[]b = {3,3,3,4,4,4};
        print(a,b);
    }
}
