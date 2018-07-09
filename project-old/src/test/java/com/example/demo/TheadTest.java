package com.example.demo;

import org.junit.Test;

public class TheadTest {

    class DemoThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread());
//            super.run();
            // Perform time-consuming operation...
        }
    }

    @Test
    public void test1() {
        DemoThread t = new DemoThread();
        t.start();
//        t.start();
        Thread sub1 = new Thread(t);
        Thread sub2 = new Thread(t);
        sub1.start();
        sub2.start();

    }


}
