package com.example.demo.thread;

import java.util.concurrent.TimeUnit;

public class SleepTest {

    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
