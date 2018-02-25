package com.example.demo.thread;

public class ThreadLoclTest {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        thread.setName("ThreadLoclTest");

        ThreadLocal threadLocal = new ThreadLocal();
        Object o = threadLocal.get();
        threadLocal.set(123);

        ThreadLocal threadLocal2 = new ThreadLocal();
        Object o2 = threadLocal2.get();
        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());
        System.out.println(o2);
    }
}
