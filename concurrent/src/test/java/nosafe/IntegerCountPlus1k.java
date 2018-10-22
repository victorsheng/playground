package nosafe;

import org.junit.Test;

public class IntegerCountPlus1k {

  private static Integer i = 0;

  /**
   * 始终是1k
   */
  @Test
  public void main() {
    Task task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    printIntegerAddress();
  }

  private void printIntegerAddress() {
    System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));
  }

  @Test
  public void main2() {
    Task task = new Task(i);
    new Thread(task).start();
    new Thread(task).start();
    new Thread(task).start();
    printIntegerAddress();
  }

  static class Task implements Runnable {

    private Integer i;

    public Task(Integer i) {
      this.i = i;
    }

    @Override
    public void run() {
      for (int j = 0; j < 1000; j++) {
        i++;
      }
      System.out.println(Thread.currentThread().getName() + ":" + i);
      System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));

    }
  }

}
