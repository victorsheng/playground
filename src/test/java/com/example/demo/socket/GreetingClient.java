package com.example.demo.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class GreetingClient {

  public static void main(String[] args) throws InterruptedException {
    String serverName = "localhost";
    int port = 16066;
    try {
      System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
      Socket client = new Socket(serverName, port);
//      client.setSoLinger(true, 0);
      System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
      OutputStream outToServer = client.getOutputStream();
      DataOutputStream out = new DataOutputStream(outToServer);

      out.writeUTF("Hello from " + client.getLocalSocketAddress());
      InputStream inFromServer = client.getInputStream();
      DataInputStream in = new DataInputStream(inFromServer);
      System.out.println("服务器响应： " + in.readUTF());
//      client.close();
      Thread.sleep(100000000);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

    }
  }
}