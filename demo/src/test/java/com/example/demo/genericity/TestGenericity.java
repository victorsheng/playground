package com.example.demo.genericity;

import java.util.ArrayList;
import java.util.List;

public class TestGenericity<T> {

  public <T> void print(T t) {
    System.out.println(t);
  }


  public void getData(List<?> data) {
    System.out.println("data :" + data.get(0));
    System.out.println("data :" + data.get(1));
    List<?> list = new ArrayList<String>();
  }


  public static void main(String[] args) {
    TestGenericity<Object> objectTestGenericity = new TestGenericity<>();
    ArrayList data = new ArrayList();
    data.add("111");
    data.add(22);
    objectTestGenericity.getData(data);

    List<?> list = new ArrayList<String>();
  }


}
