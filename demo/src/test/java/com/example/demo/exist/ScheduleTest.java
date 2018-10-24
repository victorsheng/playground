package com.example.demo.exist;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTest {

  public static void main(String[] args) {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
    scheduledExecutorService.scheduleWithFixedDelay(new ChildThread("1"), 0, 5, TimeUnit.SECONDS);
    scheduledExecutorService.scheduleWithFixedDelay(new ChildThread("2"), 0, 5, TimeUnit.SECONDS);
  }

}
