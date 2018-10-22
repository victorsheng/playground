package nosafe;

import java.math.BigInteger;
import org.junit.Test;

public class BigIntegerCount {

  private static BigInteger i = BigInteger.ZERO;

  @Test
  public void main2() {
    Task task = new Task(i);
    new Thread(task).start();
    new Thread(task).start();
    new Thread(task).start();
    System.out.println(Thread.currentThread().getName() + ":" + i.intValue());
    System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));
  }

  static class Task implements Runnable {

    private BigInteger i;

    public Task(BigInteger i) {
      this.i = i;
    }

    @Override
    public void run() {
      for (int j = 0; j < 1000; j++) {
        i = i.add(BigInteger.ONE);
      }
      System.out.println(Thread.currentThread().getName() + ":" + i.intValue());
      System.out.println(Thread.currentThread().getName() + ":" + System.identityHashCode(i));

    }
  }

}
