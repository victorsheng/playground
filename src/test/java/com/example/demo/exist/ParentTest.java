package com.example.demo.exist;

public class ParentTest {

  public static void main(String[] args) {
    System.out.println("parent thread begin ");

    ChildThread t1 = new ChildThread("thread1");
    ChildThread t2 = new ChildThread("thread2");
    t1.start();
    t2.start();

    System.out.println("parent thread over ");
  }
}

