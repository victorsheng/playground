package com.example.demo.proxy.springaop.advice;


import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class TicketServiceBeforeAdvice implements MethodBeforeAdvice {

  public void before(Method method, Object[] args, Object target) throws Throwable {
    System.out.println("BEFORE_ADVICE: 欢迎光临代售点....");
  }

}
