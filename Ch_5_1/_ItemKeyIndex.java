package Ch_5_1;

/**
 * Created by HuGuodong on 2019/1/13.
 */

public class _ItemKeyIndex {
  private String name;
  private int key;

  public _ItemKeyIndex(String name, int key){
    this.name = name;
    this.key = key;
  }

  public int key(){
    return key;
  }

  @Override
  public String toString() {
    return "_ItemKeyIndex{" +
        "name='" + name + '\'' +
        ", key=" + key +
        '}';
  }
}
