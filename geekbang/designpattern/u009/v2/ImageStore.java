package geekbang.designpattern.u009.v2;

import java.awt.Image;

/**
 * Created by HuGuodong on 11/22/19.
 */
public interface ImageStore {

  String upload(Image image, String bucketName);

  Image download(String url);
}

class PrivateImageStore implements ImageStore {

  @Override
  public String upload(Image image, String bucketName) {
    createBucketInfNotExisting(bucketName);
    return null;
  }

  @Override
  public Image download(String url) {
    return null;
  }

  public void createBucketInfNotExisting(String bucketName) {

  }
}

class AliyunImageStore implements ImageStore {

  @Override
  public String upload(Image image, String bucketName) {
    createBucketInfNotExisting(bucketName);
    String accessToken = generateAccessToken();
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