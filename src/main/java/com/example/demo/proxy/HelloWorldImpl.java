package com.example.demo.proxy;

public class HelloWorldImpl extends BaseClass implements HelloWorld {

    @Override
    final public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}