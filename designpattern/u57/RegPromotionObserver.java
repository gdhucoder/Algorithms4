package designpattern.u57;

/**
 * Created by HuGuodong on 3/13/20.
 */


public class RegPromotionObserver {

  private PromotionService promotionService; // 依赖注入


  public RegPromotionObserver() {
    promotionService = new PromotionService();
  }

  @Subscribe
  public void handleRegSuccess(Long userId) {
    System.out.println("handleRegSuccess...");
    promotionService.issueNewUserExperienceCash(userId);
  }
}

