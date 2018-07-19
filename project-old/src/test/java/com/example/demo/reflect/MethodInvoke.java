package com.example.demo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodInvoke {

  public static class Parent {

    public String say() {
      return "p say";

    }

    public static String play() {
      return "play";
    }
  }

  public static class Child extends Parent {

    public String say2() {
      return "c say2";

    }

    public String say() {
      return "c say";

    }

//    public static String play() {
//      return "play2";
//    }

  }


  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
    Child child = new Child();
    Method[] pa = Parent.class.getDeclaredMethods();
    Method[] declaredMethods = Child.class.getDeclaredMethods();
    System.out.println(Arrays.toString(declaredMethods));

    for (Method method : declaredMethods) {
      System.out.println(method.invoke(child));
    }
    System.out.println("-----------------------");

    for (Method method : pa) {
      System.out.println(method.invoke(child));
    }
  }

}
