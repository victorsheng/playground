package com.example.demo.basetype;

public class ByteAndInt {

  public static void main(String[] args) {
    byte i = 100;
    int i2 = 100;
    Byte i3 = new Byte(i);
    System.out.println(i == i2);
    System.out.println(i2 == i3);
    System.out.println(i == i3);

  }

}
