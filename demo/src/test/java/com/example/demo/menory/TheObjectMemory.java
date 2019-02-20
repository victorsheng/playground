//package com.example.demo.menory;
//
////import com.javamex.classmexer.MemoryUtil;
//
//import java.lang.reflect.Field;
//import sun.misc.Unsafe;
//
//
//public class TheObjectMemory {
//
//  private static Unsafe UNSAFE;
//
//  static {
//    try {
//      Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//      theUnsafe.setAccessible(true);
//      UNSAFE = (Unsafe) theUnsafe.get(null);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  /**
//   * ● 对象头：mark word(8 bytes) + class pointer(4 bytes) = 12 bytes 因为在JDK 8
//   * 中"UseCompressedOops"选项是默认启用的，因此class pointer只占用了4个字节。 同时，从属性'a'在内存中的偏移量为12也能说明，对象头仅占用了12bytes（属性a的分配紧跟在对象头后）
//   *
//   * ● 实例数据：int (4 bytes)
//   *
//   * ● 对齐填充：0 bytes 因为'对象头' + '对齐填充' 已经满足为8的倍数，因此无需填充
//   *
//   * 对象占用内存大小：对象头(12) + 实例数据(4) + 对齐填充(0) = 16
//   */
//  int a;
//
//  public static void main(String[] args) throws NoSuchFieldException {
//
////    TheObjectMemory obj = new TheObjectMemory();
//
////     memoryUsage : 16
////    System.out.println("memoryUsage : " + MemoryUtil.memoryUsageOf(obj));
//
//    // a field offset : 12
//    System.out.println("a field offset : " +
//        UNSAFE.objectFieldOffset(TheObjectMemory.class.getDeclaredField("a")));
//
//  }
//
//
//}
