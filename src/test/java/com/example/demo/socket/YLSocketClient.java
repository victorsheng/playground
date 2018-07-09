package com.example.demo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class YLSocketClient {

  public static void main(String[] args) throws InterruptedException {
    String host = "www.ejlscm.com";
    String httpStr = "GET / HTTP/1.1\r\n"
        + "cache-control: no-cache\r\n"
        + "Postman-Token: 73a9386d-fdfb-405b-adc2-8c5844d636c8\r\n"
        + "User-Agent: PostmanRuntime/7.1.1\r\n"
        + "Accept: */*\r\n"
        + "Host: www.bing.com\r\n"
        + "accept-encoding: gzip, deflate\r\n"
        + "Connection: keep-alive\r\n"
        + "\r\n";
    int port = 80;
    try {
      System.out.println("连接到主机：" + host + " ，端口号：" + port);
      Socket client = new Socket(host, port);
//      client.setSoLinger(true, 0);
      System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
      OutputStream outToServer = client.getOutputStream();
      outToServer.write(httpStr.getBytes());
//      client.shutdownOutput();
      InputStream inFromServer = client.getInputStream();

      BufferedReader br = new BufferedReader(
          new InputStreamReader(inFromServer, "GBK"));
      String data;
      while ((data = br.readLine()) != null) {
        System.out.println("服务器响应" + data);
      }

      client.close();
//      Thread.sleep(100000000);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

    }
  }
}