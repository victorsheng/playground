package com.example.demo.proxy.cglib.enhancer;

import com.example.demo.proxy.HelloWorldImpl2;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * 代理类有一个共有方法 和 私有方法
 */
public class DoCGLib2 {

  public static void main(String[] args) {
    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
        "/Users/victor/code/vicProjects/demo/project-old/doc/cglib2");

    CglibProxy proxy = new CglibProxy();
    //通过生成子类的方式创建代理类

    //设置需要创建子类的类
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(HelloWorldImpl2.class);
    enhancer.setCallback(proxy);
    //通过字节码技术动态创建子类实例
    HelloWorldImpl2 proxyImpo = (HelloWorldImpl2) enhancer.create();
    proxyImpo.sayHello("wing");
  }
}