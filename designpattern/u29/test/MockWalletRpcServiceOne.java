package designpattern.u29.test;

import designpattern.u29.WalletRpcService;

/**
 * Created by HuGuodong on 1/8/20.
 */
public class MockWalletRpcServiceOne extends WalletRpcService {

  public String moveMoney(Long id, Long fromUserId, Long toUserId, Double amount) {
    return "123bac";
  }
}
