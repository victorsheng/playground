package nosafe;

import org.junit.Test;

public class IntegerCountPlus1 {

  private static Integer i = 0;

  @Test
  public void main() {
    Task task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    System.out.println(Thread.currentThread().getName() + ":" + i);
    System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));
  }

  static class Task implements Runnable {

    private Integer i;

    public Task(Integer i) {
      this.i = i;
    }

    @Override
    public void run() {
      for (int j = 0; j < 1; j++) {
        i++;
      }
      System.out.println(Thread.currentThread().getName() + ":" + i);
      System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));

    }
  }

}
