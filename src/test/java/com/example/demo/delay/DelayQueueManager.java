package com.example.demo.delay;


import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelayQueueManager {

  private DelayQueueManager() {

  }

  private static class SingletonHolder {

    private static DelayQueueManager delayQueueManager = new DelayQueueManager();
  }

  public static DelayQueueManager getInstance() {
    return SingletonHolder.delayQueueManager;
  }

  ExecutorService executor = Executors.newFixedThreadPool(20);
  /**
   * 守护线程
   */
  private ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

  /**
   * 创建一个最初为空的新 DelayQueue
   */
  private static DelayQueue<DelayQueueTask> t = new DelayQueue<DelayQueueTask>();

  /**
   * 添加任务， time 延迟时间 task 任务 用户为问题设置延迟时间
   */
  public void put(long time, InstallDeviceTask installDeviceTask) {
    //创建一个任务,将任务放在延迟的队列中
    t.put(new DelayQueueTask(time, installDeviceTask));
  }

  /**
   * 初始化线程
   */
  public void init() {
    singleThreadExecutor.execute(new Runnable() {
      @Override
      public void run() {
        execute();
      }
    });
  }

  public void execute() {
    while (true) {
      try {
        final DelayQueueTask task = t.take();
        if (task != null) {
          final InstallDeviceTask installDeviceTask = task.getInstallDeviceTask();
          executor.execute(new Runnable() {
            @Override
            public void run() {
              //实现要做的事

            }
          });

        }
      } catch (Exception e) {
        e.printStackTrace();
        break;
      }
    }
  }
}