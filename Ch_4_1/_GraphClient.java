package Ch_4_1;

/**
 * Created by HuGuodong on 2018/11/26.
 */

public class _GraphClient {

  // 计算v的度数
  public static int degree(_Graph g, int v) {
    int degree = 0;
    for (int w : g.adj(v)) {
      degree++;
    }
    return degree;
  }

  // 计算所有顶点的最大度数
  public static int maxDegree(_Graph g) {
    int max = 0;
    for (int v = 0; v < g.V(); v++) {
      if (degree(g, v) > max) {
        max = degree(g, v);
      }
    }
    return max;
  }

  // 计算顶点的平均度数
  public static double avgDegree(_Graph g) {
    return 2.0 * g.E() / g.V();
  }

  // 计算自环的个数
  public static int numberOfSelfLopps(_Graph g) {
    int count = 0;
    for (int v = 0; v < g.V(); v++) {
      for (int w : g.adj(v)) {
        if (w == v) {
          count++;
        }
      }
    }
    return count / 2; // 每条边被标记两次
  }

}
