package com.example.demo.thread;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {

    private Result rs;

    public SearchTask(Result rs) {
        this.rs = rs;
    }

    @Override
    public void run() {
        String tName = Thread.currentThread().getName();
        try {
            doTask();
            rs.setName(tName);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("end" + tName);

    }

    private void doTask() throws InterruptedException {
        Random random = new Random();
        String tName = Thread.currentThread().getName();

        int i = Math.abs(random.nextInt() % 10);
        System.out.println("tName:" + tName + ",sleep:" + i);
        TimeUnit.SECONDS.sleep(i);
    }


    public static void main(String[] args) {
        Result result = new Result();
        ThreadGroup threadGroup = new ThreadGroup("search");
        SearchTask searchTask = new SearchTask(result);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
        }

        System.out.println("activeCount:" + threadGroup.activeCount());
//        threadGroup.list();

//        Thread[] ts = new Thread[threadGroup.activeCount()];
//        threadGroup.enumerate(ts);

        waitFinish(threadGroup);
        threadGroup.interrupt();


    }

    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("finish-one");
    }
}

class Result {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
