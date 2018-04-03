package com.example.demo.thread;

public class ThreadStopTest {


    public static void main(String[] args) {

        try {
            System.out.println("try");
            Thread thread = new MyThread();
            thread.start();
            Thread.sleep(700L);
            thread.stop();
//             thread.interrupt();
        } catch (Exception e) {
            System.out.println("exception");
        } finally {
            System.out.println("finally");
        }
    }
}

class MyThread extends Thread {

    public void run() {
        try {
            System.out.println("run");
            Thread.sleep(1000L);
            throw new Exception();
        } catch (Exception e) {
            System.out.println("exception ");
        } finally {
            System.out.println("MyThread-finally");
        }
    }
}
