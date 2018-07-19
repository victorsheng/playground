package com.example.demo.proxy;

public class HelloWorldImpl extends BaseClass implements HelloWorld {

  @Override
  public String sayHello(String name) {
    String x = "Hello " + name;
    System.out.println(x);
    return  x;
  }

  @Override
  public void sayHello2(String name) {
    System.out.println("Hello2222 " + name);
  }


  public void sayHello3(String name) {
    System.out.println("Hello3333 " + name);
  }


  public static void sayHello4(String name) {
    System.out.println("Hello3333 " + name);
  }

}