package Ch_5_2;

import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/3/1.
 */

public class Main {
  public static void main(String[] args){
    String txt = "helloadsfasdfsafd";
    char key = 'i';
    int[] dis = getDistance(txt, key);
    System.out.println(Arrays.toString(dis));
  }
  public static int[] getDistance(String txt, char key){
    int[] dis = new int[txt.length()];
    for(int i=0; i< txt.length(); i++){
      dis[i] = txt.charAt(i) - key;
    }
    return dis;
  }
}
