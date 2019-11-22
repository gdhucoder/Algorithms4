package geekbang.designpattern.u009.v2;

import java.awt.Image;

/**
 * Created by HuGuodong on 11/22/19.
 */
public class PrivateImageStore implements ImageStore {

  public PrivateImageStore() {

  }

  @Override
  public String upload(Image image, String bucketName) {
    createBucketInfNotExisting(bucketName);
    System.out.println("PrivateImageStore upload");
    return null;
  }

  @Override
  public Image download(String url) {
    return null;
  }

  public void createBucketInfNotExisting(String bucketName) {

  }
}