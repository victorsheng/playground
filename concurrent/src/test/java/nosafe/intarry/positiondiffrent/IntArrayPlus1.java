package nosafe.intarry.positiondiffrent;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * 经过测试,如果数组在绝对位置不重合的情况下,操作还是可以保证相对的"线程安全"
 */
public class IntArrayPlus1 {

  private static final int totalTime = 1000;
  private static int[] i = new int[totalTime];
  private static CountDownLatch latch = new CountDownLatch(1);


  @Test
  public void main() throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(8);
    for (int j = 0; j < totalTime; j++) {
      Task task = new Task(j, i, latch);
      executorService.execute(task);
    }
    latch.countDown();
    TimeUnit.SECONDS.sleep(5);
    System.out.println(Thread.currentThread().getName() + ":" + Arrays.toString(i));
  }

  static class Task implements Runnable {

    private int no;

    private int[] i;

    private CountDownLatch latch;

    public Task(int no, int[] i, CountDownLatch latch) {
      this.latch = latch;
      this.no = no;
      this.i = i;
    }

    public void run() {
      try {
        latch.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      i[no] = no;

    }
  }

}
