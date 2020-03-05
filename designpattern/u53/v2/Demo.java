package designpattern.u53.v2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by HuGuodong on 3/4/20.
 */
public class Demo {

  public static void main(String[] args) throws IOException {
    String path = "/Users/gdhu/projects/Algorithms4/designpattern/u53/";
    Directory dir = test(path);
    System.out.println(dir.countSizeOfFiles());
    System.out.println(dir.countNumOfFiles());
    Stream<Path> paths = Files.walk(Path.of(path));
    System.out.println(paths.collect(Collectors.toSet()));

  }

  private static Directory test(String path) {
    File file = new File(path);

    Directory tree = null;
    if (file.isDirectory()) {
      tree = new Directory(path);
      List<File> files = Arrays.asList(file.listFiles());
      for (File f : files) {
        if (f.isDirectory()) {
          tree.addSubNode(new Directory(f.getPath()));
        }
        else {
          tree.addSubNode(new designpattern.u53.v2.File(f.getPath()));
        }
      }
    }
    return tree;
  }

}
