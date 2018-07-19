package com.example.demo.proxy;

public class HelloWorldImpl2 {

  public String sayHello(String name) {
    String x = "Hello " + name;
    System.out.println(x + privateInvoke());
    return x;
  }

  private String privateInvoke() {
    String privateInvoke = "         ,privateInvoke";
    System.out.println(privateInvoke);
    return privateInvoke;
  }

}