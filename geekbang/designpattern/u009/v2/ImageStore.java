package geekbang.designpattern.u009.v2;

import java.awt.Image;

/**
 * Created by HuGuodong on 11/22/19.
 */
public interface ImageStore {

  String upload(Image image, String bucketName);

  Image download(String url);
}



