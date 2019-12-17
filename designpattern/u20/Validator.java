package designpattern.u20;

import java.util.regex.Pattern;

/**
 * Created by HuGuodong on 12/18/19.
 */
public class Validator {

  private static final String zeroTo255
      = "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";

  //  private static final String IP_REGEXP
//      = zeroTo255 + "\\." + zeroTo255 + "\\."
//      + zeroTo255 + "\\." + zeroTo255;
  private static final String IP_REGEXP
      = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
      + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
      + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
      + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

  private static final Pattern IP_PATTERN
      = Pattern.compile(IP_REGEXP);


  // 第一种实现方式: 使用正则表达式
  public boolean isValidIpAddressV0(String ipAddress) {
    if (ipAddress.length() == 0)
      return false;
    return IP_PATTERN.matcher(ipAddress).matches();
  }

  // 第一种实现方式: 使用正则表达式
  public boolean isValidIpAddressV1(String ipAddress) {
    if (ipAddress.length() == 0)
      return false;
    String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
        + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
        + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
        + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
    return ipAddress.matches(regex);
  }

  // 第二种实现方式: 使用现成的工具类
  public boolean isValidIpAddressV2(String ipAddress) {
    if (ipAddress.length() == 0)
      return false;
    String[] ipUnits = ipAddress.split(".");
    if (ipUnits.length != 4) {
      return false;
    }
    for (int i = 0; i < 4; ++i) {
      int ipUnitIntValue;
      try {
        ipUnitIntValue = Integer.parseInt(ipUnits[i]);
      } catch (NumberFormatException e) {
        return false;
      }
      if (ipUnitIntValue < 0 || ipUnitIntValue > 255) {
        return false;
      }
      if (i == 0 && ipUnitIntValue == 0) {
        return false;
      }
    }
    return true;
  }

  // 第三种实现方式: 不使用任何工具类
  public boolean isValidIpAddressV3(String ipAddress) {
    char[] ipChars = ipAddress.toCharArray();
    int length = ipChars.length;
    int ipUnitIntValue = -1;
    boolean isFirstUnit = true;
    int unitsCount = 0;
    for (int i = 0; i < length; ++i) {
      char c = ipChars[i];
      if (c == '.') {
        if (ipUnitIntValue < 0 || ipUnitIntValue > 255)
          return false;
        if (isFirstUnit && ipUnitIntValue == 0)
          return false;
        if (isFirstUnit)
          isFirstUnit = false;
        ipUnitIntValue = -1;
        unitsCount++;
        continue;
      }
      if (c < '0' || c > '9') {
        return false;
      }
      if (ipUnitIntValue == -1)
        ipUnitIntValue = 0;
      ipUnitIntValue = ipUnitIntValue * 10 + (c - '0');
    }
    if (ipUnitIntValue < 0 || ipUnitIntValue > 255)
      return false;
    if (unitsCount != 3)
      return false;
    return true;
  }
}
