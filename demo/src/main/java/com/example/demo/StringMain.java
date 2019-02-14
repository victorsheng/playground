package com.example.demo;

public class StringMain {

  public static void main(String[] args) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 64; i++) {
      stringBuilder.append("a");
    }
    String x = stringBuilder.toString();
    System.out.println(x);
    System.out.println(x.getBytes().length);
  }

}
