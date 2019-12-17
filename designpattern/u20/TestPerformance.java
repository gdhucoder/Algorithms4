package designpattern.u20;

import Ch_1_4._Stopwatch;


/**
 * Created by HuGuodong on 12/18/19.
 */
public class TestPerformance {

  public static void main(String[] args) {
    String[] ips = {
        "1.2.3.4",
        "000.12.23.034",
        "121.234.9.1",
        "23.45.56.12",
        "255.255.255.255",
        "255.1.0.256",
        "00.11.22.33.44",
        "123.45",
        "Im.not.IP.address"
    };
    int NUM = 100000;
    boolean isOut = false;
    Validator val = new Validator();
    _Stopwatch timer = new _Stopwatch();

    testV0(ips, NUM, isOut, val);
    System.out.println("Method 1 reg improve: " + timer.elapsedTime());

    timer.reset();
    testV1(ips, NUM, isOut, val);
    System.out.println("Method 1 reg " + timer.elapsedTime());

    timer.reset();
    testV2(ips, NUM, isOut, val);
    System.out.println("Method 2 " + timer.elapsedTime());

    timer.reset();
    testV3(ips, NUM, isOut, val);
    System.out.println("Method 3 " + timer.elapsedTime());

//    Method 1 reg improve: 0.293
//    Method 1 reg 2.228
//    Method 2 0.54
//    Method 3 0.019

  }

  private static void testV3(String[] ips, int NUM, boolean isOut, Validator val) {
    for (int i = 0; i < NUM; i++) {
      for (String ip : ips) {
        if (val.isValidIpAddressV3(ip)) {
          if (isOut)
            System.out.println(ip);
        }
      }
    }
  }


  private static void testV2(String[] ips, int NUM, boolean isOut, Validator val) {
    for (int i = 0; i < NUM; i++) {
      for (String ip : ips) {
        if (val.isValidIpAddressV2(ip)) {
          if (isOut)
            System.out.println(ip);
        }
      }
    }
  }

  private static void testV1(String[] ips, int NUM, boolean isOut, Validator val) {
    for (int i = 0; i < NUM; i++) {
      for (String ip : ips) {
        if (val.isValidIpAddressV1(ip)) {
          if (isOut)
            System.out.println(ip);
        }
      }
    }
  }

  private static void testV0(String[] ips, int NUM, boolean isOut, Validator val) {
    for (int i = 0; i < NUM; i++) {
      for (String ip : ips) {
        if (val.isValidIpAddressV0(ip)) {

          if (isOut)
            System.out.println(ip);
        }
      }
    }
  }


}
