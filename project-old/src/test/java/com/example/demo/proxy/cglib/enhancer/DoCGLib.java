package com.example.demo.proxy.cglib;

import com.example.demo.proxy.HelloWorldImpl;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class DoCGLib {

  public static void main(String[] args) {
    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
        "/Users/victor/code/vicProjects/demo/project-old/doc/cglib");

    CglibProxy proxy = new CglibProxy();
    //通过生成子类的方式创建代理类

    //设置需要创建子类的类
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(HelloWorldImpl.class);
    enhancer.setCallback(proxy);
    //通过字节码技术动态创建子类实例
    HelloWorldImpl proxyImpo = (HelloWorldImpl) enhancer.create();
    proxyImpo.sayHello("wing");
  }
}