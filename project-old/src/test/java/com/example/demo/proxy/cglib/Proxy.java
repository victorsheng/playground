package com.example.demo.proxy.cglib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.example.demo.proxy.HelloWorld;
import java.lang.reflect.Method;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class Proxy {

  @Test
  public void testInvocationHandler() throws Exception {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(HelloWorld.class);
    enhancer.setCallback(new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args)
          throws Throwable {
        if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
          return "Hello cglib!";
        } else {
          throw new RuntimeException("Do not know what to do.");
        }
      }
    });
    HelloWorld proxy = (HelloWorld) enhancer.create();
    assertEquals("Hello cglib!", proxy.sayHello(null));
    assertNotEquals("Hello cglib!", proxy.toString());
  }

  @Test
  public void testMethodInterceptor() throws Exception {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(HelloWorld.class);
    enhancer.setCallback(new MethodInterceptor() {
      @Override
      public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
          throws Throwable {
        if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
          return "Hello cglib!";
        } else {
          return proxy.invokeSuper(obj, args);
        }
      }
    });
    HelloWorld proxy = (HelloWorld) enhancer.create();
    assertEquals("Hello cglib!", proxy.sayHello(null));
    assertNotEquals("Hello cglib!", proxy.toString());
    proxy.hashCode(); // Does not throw an exception or result in an endless loop.
  }
}
