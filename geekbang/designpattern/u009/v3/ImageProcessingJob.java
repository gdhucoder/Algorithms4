package geekbang.designpattern.u009.v3;

import geekbang.designpattern.u009.FileUtils;
import geekbang.designpattern.u009.v2.ImageStore;
import java.awt.Image;

/**
 * Created by HuGuodong on 11/22/19.
 */
public class ImageProcessingJob {

  private static final String BUCKET_NAME = "ai_images_bucket";
  private static final String STORE_CLASS = "STORE_CLASS";
  private static final String PROP_PATH = "geekbang/designpattern/u009/v3/config.properties";

  public void process() {
    Image image = null;
    try {
      String storeClass = FileUtils.load(PROP_PATH)
          .getProperty(STORE_CLASS);
      ImageStore imageStore = (ImageStore) Class.forName(storeClass).newInstance();
      imageStore.upload(image, BUCKET_NAME);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    ImageProcessingJob job = new ImageProcessingJob();
    job.process();
//    PrivateImageStore upload
  }
}
