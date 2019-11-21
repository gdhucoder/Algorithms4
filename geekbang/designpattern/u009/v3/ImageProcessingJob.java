package geekbang.designpattern.u009.v3;

import geekbang.designpattern.u009.v2.ImageStore;
import java.awt.Image;

/**
 * Created by HuGuodong on 11/22/19.
 */
public class ImageProcessingJob {

  private static final String BUCKET_NAME = "ai_images_bucket";

  public void process() throws Exception {
    Image image = null;
    ImageStore imageStore = (ImageStore) Class.forName("FactoryClassName").newInstance();
    imageStore.upload(image, BUCKET_NAME);
  }
}
