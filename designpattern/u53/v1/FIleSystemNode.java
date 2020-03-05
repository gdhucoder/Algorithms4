package designpattern.u53.v1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 3/4/20.
 */
public class FIleSystemNode {

  private String path;
  private boolean isFile;
  private List<FIleSystemNode> subNodes = new ArrayList<>();

  public FIleSystemNode(String path, boolean isFile) {
    this.path = path;
    this.isFile = isFile;
  }

  public int countNumOfFiles() {
    if (isFile) return 1;
    int num = 0;
    for (FIleSystemNode node : subNodes) {
      num += node.countNumOfFiles();
    }
    return num;
  }

  public long countSizeOfFiles() {
    if (isFile) {
      File file = new File(path);
      if (!file.exists()) return 0;
      return file.length();
    }
    long size = 0;
    for (FIleSystemNode node : subNodes) {
      size += node.countSizeOfFiles();
    }
    return size;
  }

  public String getPath() {
    return path;
  }

  public void addSubNode(FIleSystemNode fileOrDir) {
    subNodes.add(fileOrDir);
  }

  public void removeSubNode(FIleSystemNode fileOrDir) {
    int size = subNodes.size();
    int i = 0;
    for (; i < size; i++) {
      if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) break;
    }
    if (i < size) subNodes.remove(i);
  }
}
