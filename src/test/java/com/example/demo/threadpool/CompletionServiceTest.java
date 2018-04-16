package com.example.demo.threadpool;

import java.util.Random;
import java.util.concurrent.*;

public class CompletionServiceTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
        for (int i = 0; i < 10; i++) {
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    TimeUnit.SECONDS.sleep(5);
                    int i1 = new Random().nextInt();
                    System.out.println(i1);
                    return i1;
                }
            });
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            Future<Integer> poll = completionService.take();
            Integer integer = poll.get();
            sum += integer;
        }
        System.out.println(sum);

    }
}
