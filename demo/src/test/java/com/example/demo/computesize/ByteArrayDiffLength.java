package com.example.demo.computesize;

import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.util.VMSupport;

public class ByteArrayDiffLength {

  public static void main(String[] args) {
    System.out.println(VMSupport.vmDetails());

    byte[] bytes;
    for (int i = 0; i < 64; i++) {
      bytes = new byte[i];
      System.out.println("length:"+i);
      System.out.println(GraphLayout.parseInstance(bytes).toPrintable());
      System.out.println("------------");
    }
  }

}

