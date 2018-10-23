package nosafe.intarry;

import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class IntArrayCountPlus100k {

  private static int[] i = new int[1];

  @Test
  public void main() throws InterruptedException {
    Task task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    System.out.println(Thread.currentThread().getName() + ":" + i[0]);
    System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));
    TimeUnit.SECONDS.sleep(10);
  }

  static class Task implements Runnable {

    private int[] i;

    public Task(int[] i) {
      this.i = i;
    }

    public void run() {
      for (int j = 0; j < 100000; j++) {
        i[0] = i[0] + 1;
      }
      System.out.println(Thread.currentThread().getName() + ":" + i[0]);
      System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));

    }
  }

}
