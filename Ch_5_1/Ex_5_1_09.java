package Ch_5_1;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/1/31.
 */

public class Ex_5_1_09 {

  public static class _LSD{

    private static int charAt(String s, int d){
      if(d<s.length()){
        return _Alphabet.LOWERCASE.toIndex(s.charAt(d));
      }else{
        return 0;
      }
    }

    /**
     * find the maxlength  in String Array
     * @param a
     * @return
     */
    private static int findMaxLenth(String[] a){
      int maxLength = 0;
      for (String s : a){
        if (s.length() > maxLength)
          maxLength = s.length();
      }
      return maxLength;
    }


    /**
     * find max length
     * add extra 0 to make every string in the same length
     * @param a
     */
    public static void sort(String[] a){
      int N = a.length;
      String[] aux = new String[N];
      int R = 26;
      int w = findMaxLenth(a); // find max length
      for (int d = w-1; d >=0 ; d--) {
        int[] count = new int[R+1];

        for (int i = 0; i < N; i++) {
          count[charAt(a[i],d)+1]++;
        }

        for (int r = 0; r < R; r++) {
          count[r+1] += count[r];
        }

        for (int i = 0; i < N; i++) {
          aux[count[charAt(a[i], d)]++] = a[i];
        }

        for (int i = 0; i < N; i++) {
          a[i] = aux[i];
        }

      }

    }

  }

  public static void main(String[] args) {
    String[] a = {"a","ab", "abef", "abe"};
    _LSD.sort(a);
    PrintUtil.show(a);
//    a	ab	abe	abef
  }

}
