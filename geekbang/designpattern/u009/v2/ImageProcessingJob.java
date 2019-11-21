package geekbang.designpattern.u009.v2;

import java.awt.Image;

/**
 * Created by HuGuodong on 11/22/19.
 */
public class ImageProcessingJob {

  private static final String BUCKET_NAME = "ai_images_bucket";

  public void process() {
    Image image = null;
    ImageStore imageStore = new PrivateImageStore();
    imageStore.upload(image, BUCKET_NAME);
  }
}
