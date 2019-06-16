package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/6/15.
 */

public class Ex_1_1_37 {

  static int[][] hits;

  private static void init(int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
  }

  public static void shuffle(int[] a){
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int r = StdRandom.uniform(0, N);
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
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
//    0:  1026	 1317	 1200	 1095	 1069	  953	  900	  859	  823	  758
//    1:   950	  932	 1268	 1234	 1083	 1014	  964	  876	  851	  828
//    2:   993	 1001	  920	 1224	 1086	 1052	 1004	  925	  914	  881
//    3:   997	  973	  863	  909	 1169	 1111	 1070	  989	  936	  983
//    4:  1001	  904	  933	  882	  853	 1257	 1148	 1093	  979	  950
//    5:  1018	  982	  910	  917	  953	  807	 1136	 1143	 1154	  980
//    6:  1017	  962	  957	  852	  927	  900	  831	 1295	 1179	 1080
//    7:   958	  967	  959	  908	  941	  903	  956	  914	 1269	 1225
//    8:  1008	 1021	  973	  974	  976	  977	  945	  923	  917	 1286
//    9:  1032	  941	 1017	 1005	  943	 1026	 1046	  983	  978	 1029
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
