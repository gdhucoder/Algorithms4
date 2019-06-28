package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/6/13.
 */

public class Ex_1_1_36 {

  static int[][] hits;

  public static void shuffle(int[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int r = i + StdRandom.uniform(N - i);
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
    StdOut.println();
  }

  private static void init(int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
  }

  public static void main(String[] args) {
    int M = 10;
    int N = 10000;
    hits = new int[M][M];

    int[] a = new int[M];
    for (int i = 0; i < N; i++) {
      init(a);
      shuffle(a);
      StdOut.print(Arrays.toString(a));
      // statics 统计交换
      for (int j = 0; j < a.length; j++) {
        hits[j][a[j]]++;
      }
    }
    StdOut.printf("\nN = %2d, M = %2d, N/M = %2d", N, M, N / M);
    print(M);

//    j     0	    1	    2	    3	    4	    5	    6	    7	    8	    9
//    -----------------------------------------------------------------
//    0:   987	  952	  947	 1004	 1089	  977	 1009	  982	 1023	 1030
//    1:  1098	 1007	  956	  986	  951	  976	 1010	 1032	 1015	  969
//    2:  1013	 1047	 1052	  995	  973	 1021	  958	  973	  960	 1008
//    3:  1002	  956	 1042	  961	  996	 1049	 1051	  971	  992	  980
//    4:  1006	 1010	 1045	 1038	  986	  943	  987	 1007	 1015	  963
//    5:  1005	 1004	  941	  961	 1018	 1021	 1024	 1028	  987	 1011
//    6:   963	  975	 1020	 1021	 1006	 1016	  925	 1046	 1047	  981
//    7:   995	  973	 1003	 1038	 1020	 1051	 1029	  959	  952	  980
//    8:   998	 1028	  995	  988	  963	  965	 1032	  994	  994	 1043
//    9:   933	 1048	  999	 1008	  998	  981	  975	 1008	 1015	 1035

  }

  private static void print(int m) {
    StdOut.println();
    StdOut.print(" j ");
    for (int i = 0; i < m; i++) {
      StdOut.printf("%5d\t", i);
    }

    StdOut.println("\n-----------------------------------------------------------------");
    for (int i = 0; i < m; i++) {
      StdOut.printf("%2d: ", i);
      for (int j = 0; j < m; j++) {
        StdOut.printf("%5d\t", hits[i][j]);
      }
      StdOut.println();
    }
  }

}
