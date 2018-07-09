package com.example.demo;

import org.junit.Test;

public class WaitTest {


    class DemoThread extends Thread {


        private Object object;

        public DemoThread(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread());
            synchronized (object){
                System.out.println(Thread.currentThread());
                try {
                    object.wait();
                    System.out.println(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Test
    public void test1() throws InterruptedException {
        Object o = new Object();



        WaitTest.DemoThread t = new DemoThread(o);
//        t.start();
        Thread sub1 = new Thread(t);
        Thread sub2 = new Thread(t);
        sub1.start();
        sub2.start();
        synchronized (o) {
            o.notifyAll();
        }
    }
}
