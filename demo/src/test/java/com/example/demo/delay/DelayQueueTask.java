package com.example.demo.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTask implements Delayed {

  /**
   * 到期时间
   */
  private long time;

  private InstallDeviceTask installDeviceTask;

  public DelayQueueTask(long timeout, InstallDeviceTask installDeviceTask) {
    this.time = timeout;
    this.installDeviceTask = installDeviceTask;
  }

  /**
   * 返回与此对象相关的剩余延迟时间，以给定的时间单位表示
   */
  @Override
  public long getDelay(TimeUnit unit) {
    return unit.convert(this.time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
  }

  @Override
  public int compareTo(Delayed other) {
    if (other == this) // compare zero ONLY if same object
    {
      return 0;
    }
    if (other instanceof DelayQueueTask) {
      DelayQueueTask x = (DelayQueueTask) other;
      long diff = time - x.time;
      if (diff < 0) {
        return -1;
      } else if (diff > 0) {
        return 1;
      } else {
        return 1;
      }
    }
    long d = (getDelay(TimeUnit.MILLISECONDS) - other.getDelay(TimeUnit.MILLISECONDS));
    return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
  }

  public InstallDeviceTask getInstallDeviceTask() {
    return installDeviceTask;
  }
}