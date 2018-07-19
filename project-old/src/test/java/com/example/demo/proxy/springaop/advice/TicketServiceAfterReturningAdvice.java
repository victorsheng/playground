package com.example.demo.proxy.springaop.advice;


import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

public class TicketServiceAfterReturningAdvice implements AfterReturningAdvice {
  @Override
  public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
    System.out.println("AFTER_RETURNING：本次服务已结束....");
  }

}
