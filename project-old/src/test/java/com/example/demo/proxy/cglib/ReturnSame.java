package com.example.demo.proxy.cglib;

import static org.junit.Assert.assertEquals;

import com.example.demo.proxy.HelloWorld;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;

public class ReturnSame {

  @Test
  public void test() {
//    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
//        "/Users/victor/code/vicProjects/demo/project-old/doc/cglib-return-same");

    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(HelloWorld.class);
    enhancer.setCallback((FixedValue) () -> "Hello Tom!");
    HelloWorld proxy = (HelloWorld) enhancer.create();

    String res = proxy.sayHello(null);

    assertEquals("Hello Tom!", res);
  }
}
