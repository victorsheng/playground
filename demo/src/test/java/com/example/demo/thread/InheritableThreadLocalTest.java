package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InheritableThreadLocalTest {


  public static void main2(String[] args) {
    final InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
    inheritableThreadLocal.set("hello");
    final InheritableThreadLocal inheritableThreadLocal1 = new InheritableThreadLocal();
    inheritableThreadLocal1.set("hello");
    final ThreadLocal threadLocal2 = new ThreadLocal();
    threadLocal2.set("hello 2");
    new Thread(new Runnable() {
      InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();

      @Override
      public void run() {
        System.out.println(inheritableThreadLocal.get());
        System.out.println(inheritableThreadLocal1.get());
        System.out.println(threadLocal2.get());
      }
    }).start();
  }


  public static void main(String[] args) {
    final InheritableThreadLocal<Span> inheritableThreadLocal = new InheritableThreadLocal<Span>();
    inheritableThreadLocal.set(new Span("xiexiexie"));
    //输出 xiexiexie
    Object o = inheritableThreadLocal.get();
    System.out.println(o);
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("========");
        System.out.println(inheritableThreadLocal.get());
        inheritableThreadLocal.set(new Span("zhangzhangzhang"));
        System.out.println(inheritableThreadLocal.get());
      }
    };
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    try {
      executorService.submit(runnable);
      TimeUnit.SECONDS.sleep(1);
      executorService.submit(runnable);
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("========");
    System.out.println(inheritableThreadLocal.get());

  }

  static class Span {

    public String name;
    public int age;

    public Span(String name) {
      this.name = name;
    }


    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("Span{");
      sb.append("name='").append(name).append('\'');
      sb.append(", age=").append(age);
      sb.append('}');
      return sb.toString();
    }
  }


}
