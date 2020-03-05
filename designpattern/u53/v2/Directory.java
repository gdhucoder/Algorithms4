package designpattern.u53.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 3/4/20.
 */
public class Directory extends FileSystemNode {

  private List<FileSystemNode> subNodes = new ArrayList<>();

  public Directory(String path) {
    super(path);
  }

  @Override
  public int countNumOfFiles() {
    int num = 0;
    for (FileSystemNode node : subNodes) {
      num += node.countNumOfFiles();
    }
    return num;
  }

  @Override
  public long countSizeOfFiles() {
    long sum = 0;
    for (FileSystemNode node : subNodes) {
      sum += node.countSizeOfFiles();
    }
    return sum;
  }

  public void addSubNode(FileSystemNode fileOrDir) {
    subNodes.add(fileOrDir);
  }

  public void removeSubNode(FileSystemNode fileOrDir) {
    int size = subNodes.size();
    int i = 0;
    for (; i < size; i++) {
      if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) break;
    }
    if (i < size) subNodes.remove(i);
  }
}
