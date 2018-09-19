package com.example.demo.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.Test;

public class CompletetTest {

  @Test
  public void name()  {
    CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
      int i = 1 / 0;
      return 100;
    });
future.join();
//    future.get();
  }
}
