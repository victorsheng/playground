package com.example.demo.threadpool;

import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class CloseTest {

  class Task implements Runnable {

    @Override
    public void run() {
      while (true) {
        if (!Thread.currentThread().isInterrupted()) {
          System.out.println("run");
        } else {
//          try {
//            throw new InterruptedException();
//          } catch (InterruptedException e) {
          System.out.println("catch  中断");
//          }
          return;
        }
      }
    }
  }

  class Task2 implements Runnable {

    @Override
    public void run() {
      while (true) {
        System.out.print("run");
      }
    }
  }


  @Test
  public void main() throws InterruptedException {
    Thread thread = new Thread(new Task());
    thread.start();
    TimeUnit.SECONDS.sleep(3
    );
    thread.interrupt();

  }

  @Test
  public void main2() throws InterruptedException {
    Thread thread = new Thread(new Task2());
    thread.start();
    TimeUnit.SECONDS.sleep(3);
    thread.interrupt();
    System.err.println();
    System.err.println("interrupt");
    TimeUnit.SECONDS.sleep(3);
  }
}
