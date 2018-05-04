package com.example.demo.string;

import org.junit.Test;

public class AppendTest {

  public static final String WOSHISUANFA = "woshisuanfa";
  public static final String B446E731146E796C35FB82E156924 = "027b446e731146e796c35fb82e156924";



  @Test
  public void string() {
    long time = System.currentTimeMillis();
    String algorithmId= B446E731146E796C35FB82E156924;
    String inputFileName = "/" + "opal"
        + "/" + "algorithms"
        + "/" + algorithmId + "_"
        + WOSHISUANFA;
    System.out.println(inputFileName);
    System.out.println(System.currentTimeMillis()-time);
  }

  @Test
  public void stringBuilder() {
    long time = System.currentTimeMillis();
    String algorithmId= B446E731146E796C35FB82E156924;
    String inputFileName = new StringBuilder("/").append("opal")
        .append("/").append("algorithms")
        .append("/").append(algorithmId).append("_")
        .append(WOSHISUANFA).toString();
    System.out.println(inputFileName);
    System.out.println(System.currentTimeMillis()-time);
  }



}
