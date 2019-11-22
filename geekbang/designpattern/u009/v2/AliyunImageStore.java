package geekbang.designpattern.u009.v2;

import java.awt.Image;

/**
 * Created by HuGuodong on 11/22/19.
 */
public class AliyunImageStore implements ImageStore {

  public AliyunImageStore() {

  }

  @Override
  public String upload(Image image, String bucketName) {
    createBucketInfNotExisting(bucketName);
    String accessToken = generateAccessToken();
    System.out.println("AliyunImageStore upload");
    return null;
  }

  @Override
  public Image download(String url) {
    return null;
  }

  private void createBucketInfNotExisting(String bucketName) {

  }

  private String generateAccessToken() {
    return null;
  }
}
