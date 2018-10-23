package com.example.demo.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Test;

public class ExceptionHanleTest {

  private ExecutorService executorService = Executors.newFixedThreadPool(3);

  @Test
  public void test1() {
    for (int i = 0; i < 100; i++) {
      executorService.submit(new ExceptionTask());
    }
  }

  @Test
  public void test2() throws ExecutionException, InterruptedException {
    for (int i = 0; i < 100; i++) {
      Future<?> submit = executorService.submit(new ExceptionTask());
      submit.get();
    }
  }

  @Test
  public void test3() throws ExecutionException, InterruptedException {
    for (int i = 0; i < 100; i++) {
      executorService.execute(new ExceptionTask());
    }
  }


  class ExceptionTask implements Runnable {

    @Override
    public void run() {
      throw new RuntimeException();
    }
  }
}
