package geekbang.designpattern.u009.v2;

/**
 * Created by HuGuodong on 11/22/19.
 */
public class ImageStoreFactory {

  private static final String PRIVATE = "private";
  private static final String ALIYUN = "aliyun";

  private ImageStoreFactory() {}

  public static ImageStore newInstance(String storeType) {
    switch (storeType) {
      case PRIVATE:
        return new PrivateImageStore();
      case ALIYUN:
        return new AliyunImageStore();
      default:
        throw new IllegalArgumentException("not implemented yet");
    }
  }
}
