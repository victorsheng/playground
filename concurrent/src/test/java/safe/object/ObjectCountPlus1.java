package safe.object;

import org.junit.Test;

public class ObjectCountPlus1 {

  private static Foo i = new Foo();

  @Test
  public void main() {
    Task task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    task = new Task(i);
    new Thread(task).start();
    System.out.println(Thread.currentThread().getName() + ":" + i.z);
    System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));
  }

  static class Task implements Runnable {

    private Foo i;

    public Task(Foo i) {
      this.i = i;
    }

    @Override
    public void run() {
      for (int j = 0; j < 1; j++) {
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
