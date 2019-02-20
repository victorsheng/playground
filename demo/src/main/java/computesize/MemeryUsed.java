package computesize;

import java.util.HashMap;

public class MemeryUsed {

  public static void main(String[] args) {

    long used = getUsed();
    System.out.println(used);
    HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    for (int i = 0; i < 10000; i++) {
      objectObjectHashMap.put(i, i);
    }
    long used2 = getUsed();
    System.out.println(used2);
  }

  private static long getUsed() {
//    return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
    return getCurrentlyAllocatedMemory();
  }

  static long getCurrentlyAllocatedMemory() {
    final Runtime runtime = Runtime.getRuntime();
    return runtime.totalMemory() - runtime.freeMemory();
  }


}
