package lock;

import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

public class ReentrackLockTest {

  @Test
  public void test1() {
    ReentrantLock reentrantLock = new ReentrantLock();
    reentrantLock.lock();
    reentrantLock.unlock();

  }

}
