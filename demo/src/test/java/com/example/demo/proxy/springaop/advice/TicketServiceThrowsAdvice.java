package com.example.demo.proxy.springaop.advice;


import java.lang.reflect.Method;
import org.springframework.aop.ThrowsAdvice;

public class TicketServiceThrowsAdvice implements ThrowsAdvice {

  public void afterThrowing(Exception ex) {
    System.out.println("AFTER_THROWING....");
  }

  public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
    System.out.println("调用过程出错啦！！！！！");
  }

}
