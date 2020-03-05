package designpattern.u53.v2;


/**
 * Created by HuGuodong on 3/4/20.
 */
public abstract class FileSystemNode {

  protected String path;

  public FileSystemNode(String path) {
    this.path = path;
  }

  public abstract int countNumOfFiles();

  public abstract long countSizeOfFiles();

  public String getPath() {
    return path;
  }
}

