package com.example.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownTest2 {

    private static class ProcessJob implements Runnable {


        private CountDownLatch startLatch;
        private CountDownLatch stopLatch;

        public ProcessJob(CountDownLatch startLatch, CountDownLatch stopLatch) {
            this.startLatch = startLatch;
            this.stopLatch = stopLatch;
        }

        @Override
        public void run() {
            try {
                startLatch.await();
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Some Job");
            stopLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int jobSize = 20;
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch stopLatch = new CountDownLatch(jobSize);
        for (int i = 0; i < jobSize; i++) {
            executorService.submit(new ProcessJob(startLatch, stopLatch));
        }
        long start = System.currentTimeMillis();
        startLatch.countDown();
        // 等待所有线程执行完任务
        stopLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("Total cost time: " + (end - start));
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
