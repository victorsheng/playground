package com.example.demo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class DiffProtoclSocketClient {

  public static void main(String[] args) throws InterruptedException {
    String host = "hz1s1";
    String httpStr = "GET / HTTP/1.1\r\n"
        + "cache-control: no-cache\r\n"
        + "Postman-Token: 73a9386d-fdfb-405b-adc2-8c5844d636c8\r\n"
        + "User-Agent: PostmanRuntime/7.1.1\r\n"
        + "Accept: */*\r\n"
        + "Host: www.bing.com\r\n"
        + "accept-encoding: gzip, deflate\r\n"
        + "Connection: keep-alive\r\n"
        + "\r\n";
    int port = 2181;
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
          new InputStreamReader(inFromServer, StandardCharsets.ISO_8859_1));
      String data;
      while ((data = br.readLine()) != null) {
        System.out.println("服务器响应" + data);
      }

//      client.close();
      TimeUnit.SECONDS.sleep(5);
      outToServer.write(httpStr.getBytes());
      while ((data = br.readLine()) != null) {
        System.out.println("服务器响应" + data);
      }
      Thread.sleep(100000000);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

    }
  }
}