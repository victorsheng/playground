package com.example.demo.thread;

public class ExceptionTest {


    public static void main(String[] args) {

        Run run = new Run();
        Thread thread = new Thread(run);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("123");
            }
        });
        thread.start();

    }
}


class Run implements Runnable {
    @Override
    public void run() {
        System.out.println("rrrrr");
        throw new RuntimeException();
    }
}