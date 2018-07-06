package com.example.demo.exist;

public class ChildThread extends Thread {

  private String name = null;

  public ChildThread(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    while (true) {
      System.out.println(this.name + "--child thead begin");

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        System.out.println(e);
      }

      System.out.println(this.name + "--child thead over");
    }
  }
}
