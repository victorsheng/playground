package com.example.demo.proxy.cglib;

import com.example.demo.proxy.HelloWorldImpl;

public class DoCGLib {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        //通过生成子类的方式创建代理类
        HelloWorldImpl proxyImp = (HelloWorldImpl) proxy.getProxy(HelloWorldImpl.class);
        proxyImp.sayHello("wing");
    }
}