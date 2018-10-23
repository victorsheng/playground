package nosafe.object;

import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class ObjectCountPlus100k {

  private static Foo i = new Foo();

  @Test
  public void main() throws InterruptedException {
    Task task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    System.out.println(Thread.currentThread().getName() + ":" + i.z);
    System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));
    TimeUnit.SECONDS.sleep(10);
  }

  static class Task implements Runnable {

    private Foo i;

    public Task(Foo i) {
      this.i = i;
    }

    public void run() {
      for (int j = 0; j < 100000; j++) {
        i.z = i.z + 1;
      }
      System.out.println(Thread.currentThread().getName() + ":" + i.z);
      System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));

    }
  }

  static class Foo {

    public int z;


  }

}
