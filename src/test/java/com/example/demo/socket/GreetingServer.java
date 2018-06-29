package com.example.demo.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GreetingServer extends Thread {

  private ServerSocket serverSocket;

  public GreetingServer(int port) throws IOException {
    serverSocket = new ServerSocket(port);
    serverSocket.setSoTimeout(1000000);
  }

  public void run() {
    while (true) {
      try {
        System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
        while (true) {
          Socket server = serverSocket.accept();
//          server.setSoLinger(true, 0);
          System.out
              .println("远程主机地址-----：" + server.getLocalSocketAddress() + server.getLocalPort());
          DataInputStream in = new DataInputStream(server.getInputStream());
          System.out.println(in.readUTF());
          DataOutputStream out = new DataOutputStream(server.getOutputStream());
          out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");
          server.close();
        }
      } catch (SocketTimeoutException s) {
        System.out.println("Socket timed out!");
        break;
      } catch (IOException e) {
        e.printStackTrace();
        break;
      }
    }
  }

  public static void main(String[] args) {
    int port = 16066;
    try {
      Thread t = new GreetingServer(port);
      t.run();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}