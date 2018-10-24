package com.example.demo.security;

public class LengthTest {

  public static void main(String[] args) {
    String body = "qwertyuiopasdfghjkl;zxcvbnm,.1234567890";
    String target = "";
    for (int i = 0; i < 1000; i++) {
      target += body;
    }
    System.out.println(target.length());
    System.out.println("8866bc72625133c2416d727259ec3fd2".length());

  }
}
