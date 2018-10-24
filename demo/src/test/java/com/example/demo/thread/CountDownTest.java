package com.example.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownTest {
}


class VideoConference implements Runnable {

    private final CountDownLatch countDownLatch;

    public VideoConference(Integer num) {
        countDownLatch = new CountDownLatch(num);
    }

    @Override
    public void run() {
        System.out.println(countDownLatch.getCount());
        try {
            countDownLatch.await();
            System.out.println("会议正式开始");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void arrive(String name) {
        System.out.println("arrive" + name);
        countDownLatch.countDown();
        System.out.println("arriveNum" + countDownLatch.getCount());
    }
}

class Participant implements Runnable {

    private VideoConference videoConference;

    private String name;

    public Participant(VideoConference videoConference, String name) {
        this.videoConference = videoConference;
        this.name = name;
    }

    @Override
    public void run() {
        long sleepTime = (long) Math.random() * 10;
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        videoConference.arrive(name);
    }
}

class Main {

    public static void main(String[] args) {
        VideoConference videoConference = new VideoConference(10);
        Thread thread = new Thread(videoConference);
        thread.start();
        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(videoConference, "Person" + i);
            Thread pt = new Thread(participant);
            pt.start();
        }
    }
}