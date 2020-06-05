package ALeetCode.interview.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by HuGuodong on 2020/6/5.
 */

public class DemoServer extends Thread {

  private ServerSocket serverSocket;

  public int getPort() {
    return serverSocket.getLocalPort();
  }

  public void run() {
    try {
      serverSocket = new ServerSocket(0);
      while (true) {
        Socket socket = serverSocket.accept();
        RequestHandler requestHandler = new RequestHandler(socket);
        requestHandler.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (serverSocket != null) {
        try {
          serverSocket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
        ;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    DemoServer server = new DemoServer();
    server.start();
    try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
      BufferedReader bufferedReader = new BufferedReader(
          new InputStreamReader(client.getInputStream()));
      bufferedReader.lines().forEach(System.out::println);
    }
  }
}

// 简化实现，不做读取，直接发送字符串
class RequestHandler extends Thread {

  private Socket socket;

  RequestHandler(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
      out.println("Hello world!");
      out.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
