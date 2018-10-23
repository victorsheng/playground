package illegal;

import org.junit.Test;

/**
 * 继承的方式不能多次start
 */
public class MultiStart {

  @Test
  public void main() {
    Task task = new Task();
    task.start();
    task.start();
  }

  static class Task extends Thread {

    @Override
    public void run() {
      System.out.println("run");
    }
  }

}
