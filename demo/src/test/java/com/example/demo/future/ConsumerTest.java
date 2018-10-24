package com.example.demo.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ConsumerTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
      return 100;
    });
    CompletableFuture<Void> f =  future.thenAccept(System.out::println);
    System.out.println(f.get());
  }

}
