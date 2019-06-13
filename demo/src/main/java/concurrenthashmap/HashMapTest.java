package concurrenthashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(100);
//    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> map = new ConcurrentHashMap<>();
    final AtomicInteger atomicInteger = new AtomicInteger();
    for (int i = 0; i < 10000; i++) {
      executorService.submit(new Runnable() {
        @Override
        public void run() {
          int andIncrement = atomicInteger.getAndIncrement();
          map.put(andIncrement, andIncrement);
        }
      });
    }
    TimeUnit.SECONDS.sleep(10);
    System.out.println(map.size());
    //998

  }

}
