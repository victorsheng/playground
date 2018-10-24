//package com.example.demo.proxy.jdk;
//
//import com.example.demo.proxy.HelloWorld;
//import com.example.demo.proxy.HelloWorldImpl;
//import java.lang.reflect.Proxy;
//import org.junit.Test;
//
//public class ProxyTest {
//
//  @Test
//  public void test() {
//    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
//
//    CustomInvocationHandler handler = new CustomInvocationHandler(new HelloWorldImpl());
//    HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(
//        ProxyTest.class.getClassLoader(),
//        new Class[]{HelloWorld.class},
//        handler);
//    proxy.sayHello("Mikan");
//    proxy.sayHello2("Mikan");
//  }
//
//  @Test
//  public void testGenerateProxyClass() {
//    ProxyGeneratorUtils.writeProxyClassToHardDisk("/Users/victor/code/vicProjects/demo/project-old/doc/$Proxy11.class");
//  }
//
//}