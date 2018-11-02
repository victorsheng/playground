package com.example.demo.uuid;

import java.util.UUID;
import org.junit.Test;

public class UUIDTest {

  @Test
  public void test() {
    String string = UUID.randomUUID().toString();
    System.out.println(string);
    System.out.println(string.length());
  }

}
