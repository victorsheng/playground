package com.example.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一起开始
 */
public class AQSTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Task(countDownLatch, reentrantLock, i));
            thread.start();
        }
        countDownLatch.countDown();
    }

}

class Task implements Runnable {

    private CountDownLatch countDownLatch;

    private ReentrantLock reentrantLock;

    private Integer taskId;

    public Task(CountDownLatch countDownLatch, ReentrantLock reentrantLock, Integer taskId) {
        this.countDownLatch = countDownLatch;
        this.reentrantLock = reentrantLock;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.lock();
        System.out.println(taskId);
        reentrantLock.unlock();
    }
}
