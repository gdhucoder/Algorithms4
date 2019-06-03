package Ch_1_1;

import static Ch_1_1.Ex_1_1_33.Matrix.dot;
import static Ch_1_1.Ex_1_1_33.Matrix.mult;
import static Ch_1_1.Ex_1_1_33.Matrix.transpose;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/6/4.
 */

public class Ex_1_1_33 {

  public static class Matrix {

    /**
     * vector dot product
     */
    public static double dot(double[] x, double[] y) {
      if (x == null || y == null) {
        throw new IllegalArgumentException("array is null");
      }
      if (x.length != y.length) {
        throw new IllegalArgumentException("x's length is not equal to y's");
      }
      int N = x.length;
      double ret = 0;
      for (int i = 0; i < N; i++) {
        ret += x[i] * y[i];
      }
      return ret;
    }

    // matrix-matrix product
    public static double[][] mult(double[][] a, double[][] b) {
      return null;
    }

    // transpose
    public static double[][] transpose(double[][] a) {
      int Nx = a.length;
      int Ny = a[0].length;
      double[][] b = new double[Ny][Nx];
      for (int i = 0; i < Ny; i++) {
        for (int j = 0; j < Nx; j++) {
          b[i][j] = a[j][i];
        }
      }
      return b;
    }

    // matrix-vector product
    public static double[] mult(double[][] a, double[] x) {
      if(a[0].length!=x.length){
        throw new IllegalArgumentException("wrong dimension");
      }
      int N = a.length;
      double[] ret = new double[N];
      for (int i = 0; i < N; i++) {
        ret[i] = dot(a[i],x);
      }
      return ret;
    }

    // vector-matrix product
    public static double[] mult(double[] y, double[][] a) {
      return null;
    }


  }

  @Test
  public void testMult1(){

    // test mult
    double[][] x1 = {{4,3,1}, {1,-2,3}, {5,7,0}};
    double[] y = {7,2,1};

    double[] ret = mult(x1,y);
    PrintUtil.show(ret);
//    [35.0, 6.0, 49.0]
  }

  public static void main(String[] args) {

    // test dot
    double[] x = {1, 2, 3};
    double[] y = {1, 2, 3};
    double dot = dot(x, y);
    StdOut.printf("dot: x.y = %f\n", dot);

    // test transpose
    double[][] a = new double[2][3];
    int num = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        a[i][j] = num++;
      }
    }
    StdOut.println("Transpose");
    PrintUtil.show(a);
    a = transpose(a);
    PrintUtil.show(a);


  }
}
