package safe.intarry;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * 可以保证3个线程,最后的结果是300000
 */
public class IntArrayCountPlus100k {

  private static AtomicInteger[] i = new AtomicInteger[1];

  @Test
  public void main() throws InterruptedException {
    i[0] = new AtomicInteger(0);
    Task task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));
    TimeUnit.SECONDS.sleep(10);
  }

  static class Task implements Runnable {

    private AtomicInteger[] i;

    public Task(AtomicInteger[] i) {
      this.i = i;
    }

    public void run() {
      for (int j = 0; j < 100000; j++) {
        i[0].incrementAndGet();
      }
      System.out.println(Thread.currentThread().getName() + ":" + i[0].get());
      System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));

    }
  }

}
