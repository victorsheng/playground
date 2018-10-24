package com.example.demo.httpclient;

import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class HttpTest {


  @Test
  public void test1() throws IOException {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpget = new HttpGet("http://www.bing.com//");
    CloseableHttpResponse response = httpclient.execute(httpget);
    try {
      // TODO
    } finally {
//      response.close();
      System.out.println(11);
    }
  }
}
