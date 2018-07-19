package com.example.demo.proxy.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {


  //实现MethodInterceptor接口方法
  public Object intercept(Object obj, Method method, Object[] args,
      MethodProxy proxy) throws Throwable {
    System.out.println("前置代理");
    //通过代理类调用父类中的方法
    Object result = proxy.invokeSuper(obj, args);
    System.out.println(method.toString());
    System.out.println("后置代理");
    return result;
  }
}