package designpattern.u19;

/**
 * Created by HuGuodong on 12/16/19.
 */
public class Person {

  private String name;
  private Phone phone;

  public Person(String name, Phone phone) {
    this.name = name;
    this.phone = phone;
  }

  public void makeCall() {
    phone.call();
  }

  public void playGame() {
    phone.play();
  }

  public static void main(String[] args) {
    Phone iPhone = new iPhone(); // 第三方
    Person xiaoming = new Person("xiaoming", iPhone); // 依赖注入
    xiaoming.makeCall();
    xiaoming.playGame();

  }
}

