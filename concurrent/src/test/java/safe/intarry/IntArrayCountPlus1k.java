package safe.intarry;

import org.junit.Test;

public class IntArrayCountPlus1k {

  private static int[] i = new int[1];

  @Test
  public void main() {
    Task task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    System.out.println(Thread.currentThread().getName() + ":" + i[0]);
    System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));
  }

  static class Task implements Runnable {

    private int[] i;

    public Task(int[] i) {
      this.i = i;
    }

    @Override
    public void run() {
      for (int j = 0; j < 1000; j++) {
        i[0] = i[0] + 1;
      }
      System.out.println(Thread.currentThread().getName() + ":" + i[0]);
      System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));

    }
  }

}
